import React, { useState } from 'react';
import { Modal, ModalHeader, ModalBody, ModalFooter, Button } from 'reactstrap';

const MessagePopup = ({ isOpen, toggle, sendMessage }) => {
  const [message, setMessage] = useState('');

  const handleSendMessage = () => {
    sendMessage(message);
    setMessage('');
  };

  return (
    <Modal isOpen={isOpen} toggle={toggle}>
      <ModalHeader toggle={toggle}>Envoyer un message</ModalHeader>
      <ModalBody>
        <textarea
          className="form-control"
          placeholder="Saisissez votre message ici..."
          value={message}
          onChange={(e) => setMessage(e.target.value)}
        />
      </ModalBody>
      <ModalFooter>
        <Button color="primary" onClick={handleSendMessage}>Envoyer</Button>
        <Button color="secondary" onClick={toggle}>Annuler</Button>
      </ModalFooter>
    </Modal>
  );
};

export default MessagePopup;
