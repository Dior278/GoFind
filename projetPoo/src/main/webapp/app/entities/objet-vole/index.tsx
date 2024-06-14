import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import ObjetVole from './objet-vole';
import ObjetVoleDetail from './objet-vole-detail';
import ObjetVoleUpdate from './objet-vole-update';
import ObjetVoleDeleteDialog from './objet-vole-delete-dialog';

const ObjetVoleRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<ObjetVole />} />
    <Route path="new" element={<ObjetVoleUpdate />} />
    <Route path=":id">
      <Route index element={<ObjetVoleDetail />} />
      <Route path="edit" element={<ObjetVoleUpdate />} />
      <Route path="delete" element={<ObjetVoleDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default ObjetVoleRoutes;
