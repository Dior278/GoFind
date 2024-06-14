import React from 'react';

import MenuItem from 'app/shared/layout/menus/menu-item';

const EntitiesMenu = () => {
  return (
    <>
      {/* prettier-ignore */}
      <MenuItem icon="asterisk" to="/trajet">
        Trajet
      </MenuItem>
      <MenuItem icon="asterisk" to="/objet-vole">
        Objet Vole
      </MenuItem>
      <MenuItem icon="asterisk" to="/maison">
        Maison
      </MenuItem>
      <MenuItem icon="asterisk" to="/piece-a-louer">
        Piece A Louer
      </MenuItem>
      <MenuItem icon="asterisk" to="/utilisateur">
        Utilisateur
      </MenuItem>
      <MenuItem icon="asterisk" to="/application-user">
        Application User
      </MenuItem>
      {/* jhipster-needle-add-entity-to-menu - JHipster will add entities to the menu here */}
    </>
  );
};

export default EntitiesMenu;
