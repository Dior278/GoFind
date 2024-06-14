import React from 'react';
import { Route } from 'react-router-dom';

import ErrorBoundaryRoutes from 'app/shared/error/error-boundary-routes';

import PieceALouer from './piece-a-louer';
import PieceALouerDetail from './piece-a-louer-detail';
import PieceALouerUpdate from './piece-a-louer-update';
import PieceALouerDeleteDialog from './piece-a-louer-delete-dialog';

const PieceALouerRoutes = () => (
  <ErrorBoundaryRoutes>
    <Route index element={<PieceALouer />} />
    <Route path="new" element={<PieceALouerUpdate />} />
    <Route path=":id">
      <Route index element={<PieceALouerDetail />} />
      <Route path="edit" element={<PieceALouerUpdate />} />
      <Route path="delete" element={<PieceALouerDeleteDialog />} />
    </Route>
  </ErrorBoundaryRoutes>
);

export default PieceALouerRoutes;
