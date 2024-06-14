import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './maison.reducer';

export const MaisonDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const maisonEntity = useAppSelector(state => state.maison.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="maisonDetailsHeading">Maison</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{maisonEntity.id}</dd>
          <dt>
            <span id="adresse">Adresse</span>
          </dt>
          <dd>{maisonEntity.adresse}</dd>
          <dt>
            <span id="cheminPhotoMaison">Chemin Photo Maison</span>
          </dt>
          <dd>{maisonEntity.cheminPhotoMaison}</dd>
          <dt>
            <span id="nbrePiece">Nbre Piece</span>
          </dt>
          <dd>{maisonEntity.nbrePiece}</dd>
          <dt>
            <span id="disponibilite">Disponibilite</span>
          </dt>
          <dd>{maisonEntity.disponibilite ? 'true' : 'false'}</dd>
          <dt>
            <span id="prixLocation">Prix Location</span>
          </dt>
          <dd>{maisonEntity.prixLocation}</dd>
          <dt>
            <span id="proprietaire">Proprietaire</span>
          </dt>
          <dd>{maisonEntity.proprietaire}</dd>
          <dt>Application User</dt>
          <dd>{maisonEntity.applicationUser ? maisonEntity.applicationUser.id : ''}</dd>
          <dt>Utilisateur</dt>
          <dd>{maisonEntity.utilisateur ? maisonEntity.utilisateur.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/maison" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/maison/${maisonEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default MaisonDetail;
