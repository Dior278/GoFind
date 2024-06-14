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
import { IPieceALouer } from 'app/shared/model/piece-a-louer.model';
import { getEntity, updateEntity, createEntity, reset } from './piece-a-louer.reducer';

export const PieceALouerUpdate = () => {
  const dispatch = useAppDispatch();

  const navigate = useNavigate();

  const { id } = useParams<'id'>();
  const isNew = id === undefined;

  const applicationUsers = useAppSelector(state => state.applicationUser.entities);
  const utilisateurs = useAppSelector(state => state.utilisateur.entities);
  const pieceALouerEntity = useAppSelector(state => state.pieceALouer.entity);
  const loading = useAppSelector(state => state.pieceALouer.loading);
  const updating = useAppSelector(state => state.pieceALouer.updating);
  const updateSuccess = useAppSelector(state => state.pieceALouer.updateSuccess);

  const handleClose = () => {
    navigate('/piece-a-louer' + location.search);
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
    if (values.prixLocation !== undefined && typeof values.prixLocation !== 'number') {
      values.prixLocation = Number(values.prixLocation);
    }

    const entity = {
      ...pieceALouerEntity,
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
      ? {}
      : {
          ...pieceALouerEntity,
          applicationUser: pieceALouerEntity?.applicationUser?.id,
          utilisateur: pieceALouerEntity?.utilisateur?.id,
        };

  return (
    <div>
      <Row className="justify-content-center">
        <Col md="8">
          <h2 id="goFindApp.pieceALouer.home.createOrEditLabel" data-cy="PieceALouerCreateUpdateHeading">
            Create or edit a Piece A Louer
          </h2>
        </Col>
      </Row>
      <Row className="justify-content-center">
        <Col md="8">
          {loading ? (
            <p>Loading...</p>
          ) : (
            <ValidatedForm defaultValues={defaultValues()} onSubmit={saveEntity}>
              {!isNew ? (
                <ValidatedField name="id" required readOnly id="piece-a-louer-id" label="ID" validate={{ required: true }} />
              ) : null}
              <ValidatedField
                label="Adresse"
                id="piece-a-louer-adresse"
                name="adresse"
                data-cy="adresse"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                label="Chemin Photo Piece"
                id="piece-a-louer-cheminPhotoPiece"
                name="cheminPhotoPiece"
                data-cy="cheminPhotoPiece"
                type="text"
              />
              <ValidatedField
                label="Disponibilite"
                id="piece-a-louer-disponibilite"
                name="disponibilite"
                data-cy="disponibilite"
                check
                type="checkbox"
              />
              <ValidatedField
                label="Prix Location"
                id="piece-a-louer-prixLocation"
                name="prixLocation"
                data-cy="prixLocation"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                  validate: v => isNumber(v) || 'This field should be a number.',
                }}
              />
              <ValidatedField
                label="Proprietaire"
                id="piece-a-louer-proprietaire"
                name="proprietaire"
                data-cy="proprietaire"
                type="text"
                validate={{
                  required: { value: true, message: 'This field is required.' },
                }}
              />
              <ValidatedField
                id="piece-a-louer-applicationUser"
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
              <ValidatedField id="piece-a-louer-utilisateur" name="utilisateur" data-cy="utilisateur" label="Utilisateur" type="select">
                <option value="" key="0" />
                {utilisateurs
                  ? utilisateurs.map(otherEntity => (
                      <option value={otherEntity.id} key={otherEntity.id}>
                        {otherEntity.id}
                      </option>
                    ))
                  : null}
              </ValidatedField>
              <Button tag={Link} id="cancel-save" data-cy="entityCreateCancelButton" to="/piece-a-louer" replace color="info">
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

export default PieceALouerUpdate;
