import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import Trajet from './trajet';
import ObjetVole from './objet-vole';
import Maison from './maison';
import PieceALouer from './piece-a-louer';
import Utilisateur from './utilisateur';
import ApplicationUser from './application-user';
/* jhipster-needle-add-route-import - JHipster will add routes here */

export default () => {
  return (
    <div>
      <ErrorBoundaryRoutes>
        {/* prettier-ignore */}
        <Route path="trajet/*" element={<Trajet />} />
        <Route path="objet-vole/*" element={<ObjetVole />} />
        <Route path="maison/*" element={<Maison />} />
        <Route path="piece-a-louer/*" element={<PieceALouer />} />
        <Route path="utilisateur/*" element={<Utilisateur />} />
        <Route path="application-user/*" element={<ApplicationUser />} />
        {/* jhipster-needle-add-route-path - JHipster will add routes here */}
      </ErrorBoundaryRoutes>
    </div>
  );
};
