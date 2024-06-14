import React, { useState, useEffect } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import { Button, Table } from 'reactstrap';
import { Translate, TextFormat, getPaginationState, JhiPagination, JhiItemCount } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faSort, faSortUp, faSortDown } from '@fortawesome/free-solid-svg-icons';
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { ASC, DESC, ITEMS_PER_PAGE, SORT } from 'app/shared/util/pagination.constants';
import { overridePaginationStateWithQueryParams } from 'app/shared/util/entity-utils';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntities } from './objet-vole.reducer';

export const ObjetVole = () => {
  const dispatch = useAppDispatch();

  const pageLocation = useLocation();
  const navigate = useNavigate();

  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getPaginationState(pageLocation, ITEMS_PER_PAGE, 'id'), pageLocation.search),
  );

  const objetVoleList = useAppSelector(state => state.objetVole.entities);
  const loading = useAppSelector(state => state.objetVole.loading);
  const totalItems = useAppSelector(state => state.objetVole.totalItems);

  const getAllEntities = () => {
    dispatch(
      getEntities({
        page: paginationState.activePage - 1,
        size: paginationState.itemsPerPage,
        sort: `${paginationState.sort},${paginationState.order}`,
      }),
    );
  };

  const sortEntities = () => {
    getAllEntities();
    const endURL = `?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`;
    if (pageLocation.search !== endURL) {
      navigate(`${pageLocation.pathname}${endURL}`);
    }
  };

  useEffect(() => {
    sortEntities();
  }, [paginationState.activePage, paginationState.order, paginationState.sort]);

  useEffect(() => {
    const params = new URLSearchParams(pageLocation.search);
    const page = params.get('page');
    const sort = params.get(SORT);
    if (page && sort) {
      const sortSplit = sort.split(',');
      setPaginationState({
        ...paginationState,
        activePage: +page,
        sort: sortSplit[0],
        order: sortSplit[1],
      });
    }
  }, [pageLocation.search]);

  const sort = p => () => {
    setPaginationState({
      ...paginationState,
      order: paginationState.order === ASC ? DESC : ASC,
      sort: p,
    });
  };

  const handlePagination = currentPage =>
    setPaginationState({
      ...paginationState,
      activePage: currentPage,
    });

  const handleSyncList = () => {
    sortEntities();
  };

  const getSortIconByFieldName = (fieldName: string) => {
    const sortFieldName = paginationState.sort;
    const order = paginationState.order;
    if (sortFieldName !== fieldName) {
      return faSort;
    } else {
      return order === ASC ? faSortUp : faSortDown;
    }
  };

  return (
    <div>
      <h2 id="objet-vole-heading" data-cy="ObjetVoleHeading">
        Objet Voles
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} /> Refresh list
          </Button>
          <Link to="/objet-vole/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Objet Vole
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {objetVoleList && objetVoleList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  ID <FontAwesomeIcon icon={getSortIconByFieldName('id')} />
                </th>
                <th className="hand" onClick={sort('nom')}>
                  Nom <FontAwesomeIcon icon={getSortIconByFieldName('nom')} />
                </th>
                <th className="hand" onClick={sort('type')}>
                  Type <FontAwesomeIcon icon={getSortIconByFieldName('type')} />
                </th>
                <th className="hand" onClick={sort('dateVole')}>
                  Date Vole <FontAwesomeIcon icon={getSortIconByFieldName('dateVole')} />
                </th>
                <th className="hand" onClick={sort('cheminPhotoObjet')}>
                  Chemin Photo Objet <FontAwesomeIcon icon={getSortIconByFieldName('cheminPhotoObjet')} />
                </th>
                <th className="hand" onClick={sort('cheminFacture')}>
                  Chemin Facture <FontAwesomeIcon icon={getSortIconByFieldName('cheminFacture')} />
                </th>
                <th className="hand" onClick={sort('etat')}>
                  Etat <FontAwesomeIcon icon={getSortIconByFieldName('etat')} />
                </th>
                <th className="hand" onClick={sort('adresseProprietaire')}>
                  Adresse Proprietaire <FontAwesomeIcon icon={getSortIconByFieldName('adresseProprietaire')} />
                </th>
                <th>
                  Application User <FontAwesomeIcon icon="sort" />
                </th>
                <th>
                  Utilisateur <FontAwesomeIcon icon="sort" />
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {objetVoleList.map((objetVole, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/objet-vole/${objetVole.id}`} color="link" size="sm">
                      {objetVole.id}
                    </Button>
                  </td>
                  <td>{objetVole.nom}</td>
                  <td>{objetVole.type}</td>
                  <td>{objetVole.dateVole ? <TextFormat type="date" value={objetVole.dateVole} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>{objetVole.cheminPhotoObjet}</td>
                  <td>{objetVole.cheminFacture}</td>
                  <td>{objetVole.etat}</td>
                  <td>{objetVole.adresseProprietaire}</td>
                  <td>
                    {objetVole.applicationUser ? (
                      <Link to={`/application-user/${objetVole.applicationUser.id}`}>{objetVole.applicationUser.id}</Link>
                    ) : (
                      ''
                    )}
                  </td>
                  <td>
                    {objetVole.utilisateur ? <Link to={`/utilisateur/${objetVole.utilisateur.id}`}>{objetVole.utilisateur.id}</Link> : ''}
                  </td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/objet-vole/${objetVole.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/objet-vole/${objetVole.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                      </Button>
                      <Button
                        onClick={() =>
                          (window.location.href = `/objet-vole/${objetVole.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`)
                        }
                        color="danger"
                        size="sm"
                        data-cy="entityDeleteButton"
                      >
                        <FontAwesomeIcon icon="trash" /> <span className="d-none d-md-inline">Delete</span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        ) : (
          !loading && <div className="alert alert-warning">No Objet Voles found</div>
        )}
      </div>
      {totalItems ? (
        <div className={objetVoleList && objetVoleList.length > 0 ? '' : 'd-none'}>
          <div className="justify-content-center d-flex">
            <JhiItemCount page={paginationState.activePage} total={totalItems} itemsPerPage={paginationState.itemsPerPage} />
          </div>
          <div className="justify-content-center d-flex">
            <JhiPagination
              activePage={paginationState.activePage}
              onSelect={handlePagination}
              maxButtons={5}
              itemsPerPage={paginationState.itemsPerPage}
              totalItems={totalItems}
            />
          </div>
        </div>
      ) : (
        ''
      )}
    </div>
  );
};

export default ObjetVole;
