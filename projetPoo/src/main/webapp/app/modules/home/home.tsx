import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import { Row, Col, Alert, Card, CardBody, CardTitle, CardText } from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSearch, faHouseUser, faCarSide, faBroadcastTower } from '@fortawesome/free-solid-svg-icons';

import { useAppSelector } from 'app/config/store';
import './home.scss';

export const Home = () => {
  const account = useAppSelector(state => state.authentication.account);
  const [showLocationOptions, setShowLocationOptions] = useState(false);

  return (
    <Row>
      <Col md="12" className="text-center mb-4">
        <h1 className="display-4">Bienvenue chez GoFind
        </h1>
        <p className="lead">Que souhaitez-vous faire aujourd'hui ?</p>
      </Col>
      <Col md="4">
        <Card className="mb-4 card-hover">
          <CardBody>
            <CardTitle tag="h5">
              <FontAwesomeIcon icon={faBroadcastTower} className="icon-hover" /> Identifier un objet
            </CardTitle>
            <CardText>Vérifiez si un objet (téléphone, laptop, etc.) n'a pas été déclaré volé.</CardText>
            <Link to="/identifier-objet" className="btn btn-primary">Identifier un objet</Link>
          </CardBody>
        </Card>
      </Col>
      <Col md="4">
        <Card className="mb-4 card-hover">
          <CardBody>
            <CardTitle tag="h5">
              <FontAwesomeIcon icon={faSearch} className="icon-hover" /> Rechercher un trajet de voyage
            </CardTitle>
            <CardText>Trouvez un trajet pour votre prochain voyage en co-voiturage.</CardText>
            <Link to="/rechercher-trajet" className="btn btn-primary">Rechercher un trajet</Link>
          </CardBody>
        </Card>
      </Col>
      <Col md="4">
        <Card className="mb-4 card-hover">
          <CardBody>
            <CardTitle tag="h5">
              <FontAwesomeIcon icon={faHouseUser} className="icon-hover" /> Faire une location
            </CardTitle>
            <CardText>Louez une maison ou une pièce pour vos séjours.</CardText>
            <Link to="/faire-location" className="btn btn-primary">Faire une location</Link>
          </CardBody>
        </Card>
      </Col>
      <Col md="4">
        <Card className="mb-4 card-hover">
          <CardBody>
            <CardTitle tag="h5">
              <FontAwesomeIcon icon={faBroadcastTower} className="icon-hover" /> Publier un objet
            </CardTitle>
            <CardText>Déclarez un objet comme volé ou signalé.</CardText>
            <Link to="/objet-vole" className="btn btn-secondary">Publier un objet</Link>  {/* Chemin mis à jour */}
          </CardBody>
        </Card>
      </Col>
      <Col md="4">
        <Card className="mb-4 card-hover">
          <CardBody>
            <CardTitle tag="h5">
              <FontAwesomeIcon icon={faCarSide} className="icon-hover" /> Faire du covoiturage
            </CardTitle>
            <CardText>Proposez un trajet et trouvez des passagers pour votre voyage.</CardText>
            <Link to="/trajet" className="btn btn-secondary">Faire du covoiturage</Link>
          </CardBody>
        </Card>
      </Col>
      <Col md="4">
        <Card className="mb-4 card-hover">
          <CardBody>
            <CardTitle tag="h5">
              <FontAwesomeIcon icon={faHouseUser} className="icon-hover" /> Faire une mise en location
            </CardTitle>
            <CardText>Mettez à disposition une maison ou une pièce pour la location.</CardText>
            <button className="btn btn-secondary" onClick={() => setShowLocationOptions(!showLocationOptions)}>
              Faire de la co-location
            </button>
            {showLocationOptions && (
              <div className="mt-3">
                <Link to="/maison" className="btn btn-outline-secondary d-block mb-2">
                  Mettre maison en location
                </Link>
                <Link to="/piece-a-louer" className="btn btn-outline-secondary d-block">
                  Mettre pièce en location
                </Link>
              </div>
            )}
          </CardBody>
        </Card>
      </Col>
      <Col md="12" className="mt-4">
        {account?.login ? (
          <Alert color="success">Vous êtes connecté en tant que "{account.login}".</Alert>
        ) : (
          <Alert color="warning">
            Vous n'avez pas encore de compte ? 
            <Link to="/account/register" className="alert-link">Créer un compte</Link>
          </Alert>
        )}
      </Col>
    </Row>
  );
};

export default Home;
