import trajet from 'app/entities/trajet/trajet.reducer';
import objetVole from 'app/entities/objet-vole/objet-vole.reducer';
import maison from 'app/entities/maison/maison.reducer';
import pieceALouer from 'app/entities/piece-a-louer/piece-a-louer.reducer';
import utilisateur from 'app/entities/utilisateur/utilisateur.reducer';
import applicationUser from 'app/entities/application-user/application-user.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  trajet,
  objetVole,
  maison,
  pieceALouer,
  utilisateur,
  applicationUser,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
