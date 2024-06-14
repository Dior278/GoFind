import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import {} from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './piece-a-louer.reducer';

export const PieceALouerDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const pieceALouerEntity = useAppSelector(state => state.pieceALouer.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="pieceALouerDetailsHeading">Piece A Louer</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{pieceALouerEntity.id}</dd>
          <dt>
            <span id="adresse">Adresse</span>
          </dt>
          <dd>{pieceALouerEntity.adresse}</dd>
          <dt>
            <span id="cheminPhotoPiece">Chemin Photo Piece</span>
          </dt>
          <dd>{pieceALouerEntity.cheminPhotoPiece}</dd>
          <dt>
            <span id="disponibilite">Disponibilite</span>
          </dt>
          <dd>{pieceALouerEntity.disponibilite ? 'true' : 'false'}</dd>
          <dt>
            <span id="prixLocation">Prix Location</span>
          </dt>
          <dd>{pieceALouerEntity.prixLocation}</dd>
          <dt>
            <span id="proprietaire">Proprietaire</span>
          </dt>
          <dd>{pieceALouerEntity.proprietaire}</dd>
          <dt>Application User</dt>
          <dd>{pieceALouerEntity.applicationUser ? pieceALouerEntity.applicationUser.id : ''}</dd>
          <dt>Utilisateur</dt>
          <dd>{pieceALouerEntity.utilisateur ? pieceALouerEntity.utilisateur.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/piece-a-louer" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/piece-a-louer/${pieceALouerEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default PieceALouerDetail;
