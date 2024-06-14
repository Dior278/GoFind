import axios from 'axios';
import { createAsyncThunk, isFulfilled, isPending } from '@reduxjs/toolkit';
import { cleanEntity } from 'app/shared/util/entity-utils';
import { IQueryParams, createEntitySlice, EntityState, serializeAxiosError } from 'app/shared/reducers/reducer.utils';
import { IObjetVole, defaultValue } from 'app/shared/model/objet-vole.model';
import { toast } from 'react-toastify';

const initialState: EntityState<IObjetVole> = {
  loading: false,
  errorMessage: null,
  entities: [],
  entity: defaultValue,
  updating: false,
  totalItems: 0,
  updateSuccess: false,
};

const apiUrl = 'api/objet-voles';

// Actions

export const getEntities = createAsyncThunk('objetVole/fetch_entity_list', async ({ page, size, sort }: IQueryParams) => {
  const requestUrl = `${apiUrl}?${sort ? `page=${page}&size=${size}&sort=${sort}&` : ''}cacheBuster=${new Date().getTime()}`;
  return axios.get<IObjetVole[]>(requestUrl);
});

export const getEntity = createAsyncThunk(
  'objetVole/fetch_entity',
  async (id: string | number) => {
    const requestUrl = `${apiUrl}/${id}`;
    return axios.get<IObjetVole>(requestUrl);
  },
  { serializeError: serializeAxiosError },
);

export const createEntity = createAsyncThunk(
  'objetVole/create_entity',
  async (entity: IObjetVole, thunkAPI) => {
    const formData = new FormData();
    Object.keys(entity).forEach(key => {
      formData.append(key, entity[key]);
    });
    const result = await axios.post<IObjetVole>(apiUrl, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
    thunkAPI.dispatch(getEntities({}));
    return result;
  },
  { serializeError: serializeAxiosError },
);

export const updateEntity = createAsyncThunk(
  'objetVole/update_entity',
  async (entity: IObjetVole, thunkAPI) => {
    const formData = new FormData();
    Object.keys(entity).forEach(key => {
      formData.append(key, entity[key]);
    });
    const result = await axios.put<IObjetVole>(`${apiUrl}/${entity.id}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
    thunkAPI.dispatch(getEntities({}));
    return result;
  },
  { serializeError: serializeAxiosError },
);

export const partialUpdateEntity = createAsyncThunk(
  'objetVole/partial_update_entity',
  async (entity: IObjetVole, thunkAPI) => {
    const formData = new FormData();
    Object.keys(entity).forEach(key => {
      formData.append(key, entity[key]);
    });
    const result = await axios.patch<IObjetVole>(`${apiUrl}/${entity.id}`, formData, {
      headers: {
        'Content-Type': 'multipart/form-data',
      },
    });
    thunkAPI.dispatch(getEntities({}));
    return result;
  },
  { serializeError: serializeAxiosError },
);

export const deleteEntity = createAsyncThunk(
  'objetVole/delete_entity',
  async (id: string | number, thunkAPI) => {
    const requestUrl = `${apiUrl}/${id}`;
    const result = await axios.delete<IObjetVole>(requestUrl);
    thunkAPI.dispatch(getEntities({}));
    return result;
  },
  { serializeError: serializeAxiosError },
);

// slice

export const ObjetVoleSlice = createEntitySlice({
  name: 'objetVole',
  initialState,
  extraReducers(builder) {
    builder
      .addCase(getEntity.fulfilled, (state, action) => {
        state.loading = false;
        state.entity = action.payload.data;
      })
      .addCase(deleteEntity.fulfilled, state => {
        state.updating = false;
        state.updateSuccess = true;
        state.entity = {};
      })
      .addMatcher(isFulfilled(getEntities), (state, action) => {
        const { data, headers } = action.payload;

        return {
          ...state,
          loading: false,
          entities: data,
          totalItems: parseInt(headers['x-total-count'], 10),
        };
      })
      .addMatcher(isFulfilled(createEntity, updateEntity, partialUpdateEntity), (state, action) => {
        state.updating = false;
        state.loading = false;
        state.updateSuccess = true;
        state.entity = action.payload.data;
        toast.success('Operation completed successfully!');
      })
      .addMatcher(isPending(getEntities, getEntity), state => {
        state.errorMessage = null;
        state.updateSuccess = false;
        state.loading = true;
      })
      .addMatcher(isPending(createEntity, updateEntity, partialUpdateEntity, deleteEntity), state => {
        state.errorMessage = null;
        state.updateSuccess = false;
        state.updating = true;
      });
  },
});

export const { reset } = ObjetVoleSlice.actions;

// Reducer
export default ObjetVoleSlice.reducer;
