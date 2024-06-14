import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText, Input } from 'reactstrap';
import { isNumber, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IApplicationUser } from 'app/shared/model/application-user.model';
import { getEntities as getApplicationUsers } from 'app/entities/application-user/application-user.reducer';
import { IUtilisateur } from 'app/shared/model/utilisateur.model';
import { getEntities as getUtilisateurs } from 'app/entities/utilisateur/utilisateur.reducer';
import { IObjetVole } from 'app/shared/model/objet-vole.model';
import { getEntity, updateEntity, createEntity, reset } from './objet-vole.reducer';

export const ObjetVoleUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const applicationUsers = useAppSelector(state => state.applicationUser.entities);
  const utilisateurs = useAppSelector(state => state.utilisateur.entities);
  const objetVoleEntity = useAppSelector(state => state.objetVole.entity);
  const loading = useAppSelector(state => state.objetVole.loading);
  const updating = useAppSelector(state => state.objetVole.updating);
  const updateSuccess = useAppSelector(state => state.objetVole.updateSuccess);

  const [photoFile, setPhotoFile] = useState(null);
  const [factureFile, setFactureFile] = useState(null);

  const handleClose = () => {
    navigate('/objet-vole' + location.search);
  };

  useEffect(() => {
    if (isNew) {
      dispatch(reset());
    } else {
      dispatch(getEntity(id));
    }

    dispatch(getApplicationUsers({}));
    dispatch(getUtilisateurs({}));
  }, []);

  useEffect(() => {
    if (updateSuccess) {
      handleClose();
    }
  }, [updateSuccess]);

  const saveEntity = async values => {
    values.dateVole = convertDateTimeToServer(values.dateVole);

    const entity = {
      ...objetVoleEntity,
      ...values,
      applicationUser: applicationUsers.find(it => it.id.toString() === values.applicationUser?.toString()),
      utilisateur: utilisateurs.find(it => it.id.toString() === values.utilisateur?.toString()),
    };

    if (photoFile) {
      const formData = new FormData();
      formData.append('file', photoFile);
      // Appel API pour télécharger l'image et obtenir le chemin
      // Par exemple : const response = await axios.post('/api/upload', formData);
      // entity.cheminPhotoObjet = response.data.filePath;
    }

    if (factureFile) {
      const formData = new FormData();
      formData.append('file', factureFile);
      // Appel API pour télécharger la facture et obtenir le chemin
      // Par exemple : const response = await axios.post('/api/upload', formData);
      // entity.cheminFacture = response.data.filePath;
    }

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          dateVole: displayDefaultDateTime(),
        }
      : {
          ...objetVoleEntity,
          dateVole: convertDateTimeFromServer(objetVoleEntity.dateVole),
          applicationUser: objetVoleEntity?.applicationUser?.id,
          utilisateur: objetVoleEntity?.utilisateur?.id,
        };

  const handleFileChange = (event, setFile) => {
    setFile(event.target.files[0]);
  };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="goFindApp.objetVole.home.createOrEditLabel" data-cy="ObjetVoleCreateUpdateHeading">
            Create or edit a Objet Vole
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? <ValidatedField name="id" required readOnly id="objet-vole-id" label="ID" validate={{ required: true }} /> : null}
              <ValidatedField
                label="Nom"
                id="objet-vole-nom"
                name="nom"
                data-cy="nom"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Type"
                id="objet-vole-type"
                name="type"
                data-cy="type"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Date Vole"
                id="objet-vole-dateVole"
                name="dateVole"
                data-cy="dateVole"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <div className="mb-3">
                <label htmlFor="photoFile">Photo Objet</label>
                <Input
                  type="file"
                  id="photoFile"
                  name="photoFile"
                  onChange={event => handleFileChange(event, setPhotoFile)}
                />
              </div>
              <div className="mb-3">
                <label htmlFor="factureFile">Facture</label>
                <Input
                  type="file"
                  id="factureFile"
                  name="factureFile"
                  onChange={event => handleFileChange(event, setFactureFile)}
                />
              </div>
              <ValidatedField
                label="Etat"
                id="objet-vole-etat"
                name="etat"
                data-cy="etat"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Adresse Proprietaire"
                id="objet-vole-adresseProprietaire"
                name="adresseProprietaire"
                data-cy="adresseProprietaire"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                id="objet-vole-applicationUser"
                name="applicationUser"
                data-cy="applicationUser"
                label="Application User"
                type="select"
              >
                <option value="" key="0" />
                {applicationUsers
                  ? applicationUsers.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <ValidatedField id="objet-vole-utilisateur" name="utilisateur" data-cy="utilisateur" label="Utilisateur" type="select">
                <option value="" key="0" />
                {utilisateurs
                  ? utilisateurs.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/objet-vole" replace color="info">
                <FontAwesomeIcon icon="arrow-left" />
                &nbsp;
                <span className="d-none d-md-inline">Back</span>
              </Button>
              &nbsp;
              <Button color="primary" id="save-entity" data-cy="entityCreateSaveButton" type="submit" disabled={updating}>
                <FontAwesomeIcon icon="save" />
                &nbsp; Save
              </Button>
            </ValidatedForm>
          )}
        </Col>
      </Row>
    </div>
  );
};

export default ObjetVoleUpdate;
