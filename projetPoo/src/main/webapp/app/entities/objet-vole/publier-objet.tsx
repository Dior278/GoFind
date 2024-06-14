import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { Alert, Button, Form, FormGroup, Label, Input } from 'reactstrap';
import axios from 'axios';

export const PublierObjet = () => {
  const [nom, setNom] = useState('');
  const [type, setType] = useState('');
  const [dateVole, setDateVole] = useState('');
  const [cheminPhotoObjet, setCheminPhotoObjet] = useState('');
  const [cheminFacture, setCheminFacture] = useState('');
  const [etat, setEtat] = useState('');
  const [adresseProprietaire, setAdresseProprietaire] = useState('');
  const [message, setMessage] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async event => {
    event.preventDefault();
    const objetVole = {
      nom,
      type,
      dateVole,
      cheminPhotoObjet,
      cheminFacture,
      etat,
      adresseProprietaire,
    };
    try {
      await axios.post('/api/objet-voles', objetVole);
      setMessage("L'objet volé a été publié avec succès.");
      navigate('/');
    } catch (error) {
      console.error("Erreur lors de la publication de l'objet volé", error);
      setMessage("Erreur lors de la publication de l'objet volé.");
    }
  };

  return (
    <div>
      <h2>Publier un objet volé</h2>
      {message && <Alert color="success">{message}</Alert>}
      <Form onSubmit={handleSubmit}>
        <FormGroup>
          <Label for="nom">Nom de l'objet</Label>
          <Input
            type="text"
            name="nom"
            id="nom"
            value={nom}
            onChange={e => setNom(e.target.value)}
            required
          />
        </FormGroup>
        <FormGroup>
          <Label for="type">Type d'objet</Label>
          <Input
            type="text"
            name="type"
            id="type"
            value={type}
            onChange={e => setType(e.target.value)}
            required
          />
        </FormGroup>
        <FormGroup>
          <Label for="dateVole">Date du vol</Label>
          <Input
            type="date"
            name="dateVole"
            id="dateVole"
            value={dateVole}
            onChange={e => setDateVole(e.target.value)}
            required
          />
        </FormGroup>
        <FormGroup>
          <Label for="cheminPhotoObjet">Photo de l'objet</Label>
          <Input
            type="text"
            name="cheminPhotoObjet"
            id="cheminPhotoObjet"
            value={cheminPhotoObjet}
            onChange={e => setCheminPhotoObjet(e.target.value)}
          />
        </FormGroup>
        <FormGroup>
          <Label for="cheminFacture">Facture de l'objet</Label>
          <Input
            type="text"
            name="cheminFacture"
            id="cheminFacture"
            value={cheminFacture}
            onChange={e => setCheminFacture(e.target.value)}
          />
        </FormGroup>
        <FormGroup>
          <Label for="etat">État de l'objet</Label>
          <Input
            type="text"
            name="etat"
            id="etat"
            value={etat}
            onChange={e => setEtat(e.target.value)}
            required
          />
        </FormGroup>
        <FormGroup>
          <Label for="adresseProprietaire">Adresse du propriétaire</Label>
          <Input
            type="text"
            name="adresseProprietaire"
            id="adresseProprietaire"
            value={adresseProprietaire}
            onChange={e => setAdresseProprietaire(e.target.value)}
            required
          />
        </FormGroup>
        <Button type="submit" color="primary">Publier</Button>
      </Form>
    </div>
  );
};

export default PublierObjet;
