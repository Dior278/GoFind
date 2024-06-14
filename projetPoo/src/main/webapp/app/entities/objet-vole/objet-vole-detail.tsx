import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './objet-vole.reducer';

export const ObjetVoleDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const objetVoleEntity = useAppSelector(state => state.objetVole.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="objetVoleDetailsHeading">Objet Vole</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{objetVoleEntity.id}</dd>
          <dt>
            <span id="nom">Nom</span>
          </dt>
          <dd>{objetVoleEntity.nom}</dd>
          <dt>
            <span id="type">Type</span>
          </dt>
          <dd>{objetVoleEntity.type}</dd>
          <dt>
            <span id="dateVole">Date Vole</span>
          </dt>
          <dd>{objetVoleEntity.dateVole ? <TextFormat value={objetVoleEntity.dateVole} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="cheminPhotoObjet">Chemin Photo Objet</span>
          </dt>
          <dd>{objetVoleEntity.cheminPhotoObjet}</dd>
          <dt>
            <span id="cheminFacture">Chemin Facture</span>
          </dt>
          <dd>{objetVoleEntity.cheminFacture}</dd>
          <dt>
            <span id="etat">Etat</span>
          </dt>
          <dd>{objetVoleEntity.etat}</dd>
          <dt>
            <span id="adresseProprietaire">Adresse Proprietaire</span>
          </dt>
          <dd>{objetVoleEntity.adresseProprietaire}</dd>
          <dt>Application User</dt>
          <dd>{objetVoleEntity.applicationUser ? objetVoleEntity.applicationUser.id : ''}</dd>
          <dt>Utilisateur</dt>
          <dd>{objetVoleEntity.utilisateur ? objetVoleEntity.utilisateur.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/objet-vole" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/objet-vole/${objetVoleEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default ObjetVoleDetail;
