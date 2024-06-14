import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { TextFormat } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './trajet.reducer';

export const TrajetDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const trajetEntity = useAppSelector(state => state.trajet.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="trajetDetailsHeading">Trajet</h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">ID</span>
          </dt>
          <dd>{trajetEntity.id}</dd>
          <dt>
            <span id="lieuDepart">Lieu Depart</span>
          </dt>
          <dd>{trajetEntity.lieuDepart}</dd>
          <dt>
            <span id="lieuArrivee">Lieu Arrivee</span>
          </dt>
          <dd>{trajetEntity.lieuArrivee}</dd>
          <dt>
            <span id="dateDepart">Date Depart</span>
          </dt>
          <dd>{trajetEntity.dateDepart ? <TextFormat value={trajetEntity.dateDepart} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="heureDepart">Heure Depart</span>
          </dt>
          <dd>{trajetEntity.heureDepart ? <TextFormat value={trajetEntity.heureDepart} type="date" format={APP_DATE_FORMAT} /> : null}</dd>
          <dt>
            <span id="placeDisp">Place Disp</span>
          </dt>
          <dd>{trajetEntity.placeDisp}</dd>
          <dt>
            <span id="cheminPhotoVoiture">Chemin Photo Voiture</span>
          </dt>
          <dd>{trajetEntity.cheminPhotoVoiture}</dd>
          <dt>
            <span id="conducteur">Conducteur</span>
          </dt>
          <dd>{trajetEntity.conducteur}</dd>
          <dt>
            <span id="listePassager">Liste Passager</span>
          </dt>
          <dd>{trajetEntity.listePassager}</dd>
          <dt>Application User</dt>
          <dd>{trajetEntity.applicationUser ? trajetEntity.applicationUser.id : ''}</dd>
          <dt>Utilisateur</dt>
          <dd>{trajetEntity.utilisateur ? trajetEntity.utilisateur.id : ''}</dd>
        </dl>
        <Button tag={Link} to="/trajet" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" /> <span className="d-none d-md-inline">Back</span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/trajet/${trajetEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
        </Button>
      </Col>
    </Row>
  );
};

export default TrajetDetail;
