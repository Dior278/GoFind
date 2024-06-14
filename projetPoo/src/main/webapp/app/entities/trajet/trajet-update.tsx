import React, { useState, useEffect } from 'react';
import { Link, useNavigate, useParams } from 'react-router-dom';
import { Button, Row, Col, FormText } from 'reactstrap';
import { isNumber, ValidatedField, ValidatedForm } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { convertDateTimeFromServer, convertDateTimeToServer, displayDefaultDateTime } from 'app/shared/util/date-utils';
import { mapIdList } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { IApplicationUser } from 'app/shared/model/application-user.model';
import { getEntities as getApplicationUsers } from 'app/entities/application-user/application-user.reducer';
import { IUtilisateur } from 'app/shared/model/utilisateur.model';
import { getEntities as getUtilisateurs } from 'app/entities/utilisateur/utilisateur.reducer';
import { ITrajet } from 'app/shared/model/trajet.model';
import { getEntity, updateEntity, createEntity, reset } from './trajet.reducer';

export const TrajetUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const applicationUsers = useAppSelector(state => state.applicationUser.entities);
  const utilisateurs = useAppSelector(state => state.utilisateur.entities);
  const trajetEntity = useAppSelector(state => state.trajet.entity);
  const loading = useAppSelector(state => state.trajet.loading);
  const updating = useAppSelector(state => state.trajet.updating);
  const updateSuccess = useAppSelector(state => state.trajet.updateSuccess);

  const handleClose = () => {
    navigate('/trajet' + location.search);
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

  // eslint-disable-next-line complexity
  const saveEntity = values => {
    if (values.id !== undefined && typeof values.id !== 'number') {
      values.id = Number(values.id);
    }
    values.dateDepart = convertDateTimeToServer(values.dateDepart);
    values.heureDepart = convertDateTimeToServer(values.heureDepart);
    if (values.placeDisp !== undefined && typeof values.placeDisp !== 'number') {
      values.placeDisp = Number(values.placeDisp);
    }

    const entity = {
      ...trajetEntity,
      ...values,
      applicationUser: applicationUsers.find(it => it.id.toString() === values.applicationUser?.toString()),
      utilisateur: utilisateurs.find(it => it.id.toString() === values.utilisateur?.toString()),
    };

    if (isNew) {
      dispatch(createEntity(entity));
    } else {
      dispatch(updateEntity(entity));
    }
  };

  const defaultValues = () =>
    isNew
      ? {
          dateDepart: displayDefaultDateTime(),
          heureDepart: displayDefaultDateTime(),
        }
      : {
          ...trajetEntity,
          dateDepart: convertDateTimeFromServer(trajetEntity.dateDepart),
          heureDepart: convertDateTimeFromServer(trajetEntity.heureDepart),
          applicationUser: trajetEntity?.applicationUser?.id,
          utilisateur: trajetEntity?.utilisateur?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="goFindApp.trajet.home.createOrEditLabel" data-cy="TrajetCreateUpdateHeading">
            Create or edit a Trajet
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? <ValidatedField name="id" required readOnly id="trajet-id" label="ID" validate={{ required: true }} /> : null}
              <ValidatedField
                label="Lieu Depart"
                id="trajet-lieuDepart"
                name="lieuDepart"
                data-cy="lieuDepart"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Lieu Arrivee"
                id="trajet-lieuArrivee"
                name="lieuArrivee"
                data-cy="lieuArrivee"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Date Depart"
                id="trajet-dateDepart"
                name="dateDepart"
                data-cy="dateDepart"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Heure Depart"
                id="trajet-heureDepart"
                name="heureDepart"
                data-cy="heureDepart"
                type="datetime-local"
                placeholder="YYYY-MM-DD HH:mm"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Place Disp"
                id="trajet-placeDisp"
                name="placeDisp"
                data-cy="placeDisp"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                  validate: v => isNumber(v) || 'This field should be a number.',
                }}
              />
              <ValidatedField
                label="Chemin Photo Voiture"
                id="trajet-cheminPhotoVoiture"
                name="cheminPhotoVoiture"
                data-cy="cheminPhotoVoiture"
                type="text"
              />
              <ValidatedField
                label="Conducteur"
                id="trajet-conducteur"
                name="conducteur"
                data-cy="conducteur"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField label="Liste Passager" id="trajet-listePassager" name="listePassager" data-cy="listePassager" type="text" />
              <ValidatedField
                id="trajet-applicationUser"
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
              <ValidatedField id="trajet-utilisateur" name="utilisateur" data-cy="utilisateur" label="Utilisateur" type="select">
                <option value="" key="0" />
                {utilisateurs
                  ? utilisateurs.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/trajet" replace color="info">
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

export default TrajetUpdate;
