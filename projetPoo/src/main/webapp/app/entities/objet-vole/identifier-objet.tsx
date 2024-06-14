import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Card, CardBody, CardTitle, CardText, Row, Col, Button } from 'reactstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faCalendar, faMapMarkerAlt, faExclamationTriangle } from '@fortawesome/free-solid-svg-icons';
import './identifier-objet.scss';
import MessagePopup from '../../modules/message/MessagePopup'; // Chemin d'accès au composant MessagePopup

export const IdentifierObjet = () => {
  const [objets, setObjets] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [modal, setModal] = useState(false);
  const [selectedObjet, setSelectedObjet] = useState(null);

  useEffect(() => {
    const fetchObjets = async () => {
      try {
        const response = await axios.get('/api/objet-voles');
        setObjets(response.data);
        setLoading(false);
      } catch (error) {
        setError(error);
        setLoading(false);
      }
    };

    fetchObjets();
  }, []);

  const toggleModal = (objet) => {
    setSelectedObjet(objet);
    setModal(!modal);
  };

  if (loading) return <div>Loading...</div>;
  if (error) return <div>Error loading objects: {error.message}</div>;

  return (
    <div className="identifier-objet">
      <h2>Objets déclarés volés</h2>
      <Row>
        {objets.map(objet => (
          <Col md="4" key={objet.id}>
            <Card className="mb-4">
              <CardBody>
                <CardTitle tag="h5">{objet.nom}</CardTitle>
                <CardText>
                  <FontAwesomeIcon icon={faExclamationTriangle} /> Type: {objet.type}
                </CardText>
                <CardText>
                  <FontAwesomeIcon icon={faCalendar} /> Date du vol: {new Date(objet.dateVole).toLocaleDateString()}
                </CardText>
                {objet.adresseProprietaire && (
                  <CardText>
                    <FontAwesomeIcon icon={faMapMarkerAlt} /> Adresse: {objet.adresseProprietaire}
                  </CardText>
                )}
                {objet.cheminPhotoObjet && (
                  <div className="photo-container">
                    <img src={objet.cheminPhotoObjet} alt="Photo de l'objet" className="photo" />
                  </div>
                )}
                {objet.cheminFacture && (
                  <div className="facture-container">
                    <a href={objet.cheminFacture} target="_blank" rel="noopener noreferrer" className="btn btn-link">
                      Voir la facture
                    </a>
                  </div>
                )}
                <Button color="primary" onClick={() => toggleModal(objet)}>Prévenir le propriétaire</Button>
              </CardBody>
            </Card>
          </Col>
        ))}
      </Row>
      <MessagePopup isOpen={modal} toggle={toggleModal} sendMessage={undefined} />
    </div>
  );
};

export default IdentifierObjet;
