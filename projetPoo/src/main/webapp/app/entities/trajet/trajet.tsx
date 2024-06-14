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

import { getEntities } from './trajet.reducer';

export const Trajet = () => {
  const dispatch = useAppDispatch();

  const pageLocation = useLocation();
  const navigate = useNavigate();

  const [paginationState, setPaginationState] = useState(
    overridePaginationStateWithQueryParams(getPaginationState(pageLocation, ITEMS_PER_PAGE, 'id'), pageLocation.search),
  );

  const trajetList = useAppSelector(state => state.trajet.entities);
  const loading = useAppSelector(state => state.trajet.loading);
  const totalItems = useAppSelector(state => state.trajet.totalItems);

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
      <h2 id="trajet-heading" data-cy="TrajetHeading">
        Trajets
        <div className="d-flex justify-content-end">
          <Button className="me-2" color="info" onClick={handleSyncList} disabled={loading}>
            <FontAwesomeIcon icon="sync" spin={loading} /> Refresh list
          </Button>
          <Link to="/trajet/new" className="btn btn-primary jh-create-entity" id="jh-create-entity" data-cy="entityCreateButton">
            <FontAwesomeIcon icon="plus" />
            &nbsp; Create a new Trajet
          </Link>
        </div>
      </h2>
      <div className="table-responsive">
        {trajetList && trajetList.length > 0 ? (
          <Table responsive>
            <thead>
              <tr>
                <th className="hand" onClick={sort('id')}>
                  ID <FontAwesomeIcon icon={getSortIconByFieldName('id')} />
                </th>
                <th className="hand" onClick={sort('lieuDepart')}>
                  Lieu Depart <FontAwesomeIcon icon={getSortIconByFieldName('lieuDepart')} />
                </th>
                <th className="hand" onClick={sort('lieuArrivee')}>
                  Lieu Arrivee <FontAwesomeIcon icon={getSortIconByFieldName('lieuArrivee')} />
                </th>
                <th className="hand" onClick={sort('dateDepart')}>
                  Date Depart <FontAwesomeIcon icon={getSortIconByFieldName('dateDepart')} />
                </th>
                <th className="hand" onClick={sort('heureDepart')}>
                  Heure Depart <FontAwesomeIcon icon={getSortIconByFieldName('heureDepart')} />
                </th>
                <th className="hand" onClick={sort('placeDisp')}>
                  Place Disp <FontAwesomeIcon icon={getSortIconByFieldName('placeDisp')} />
                </th>
                <th className="hand" onClick={sort('cheminPhotoVoiture')}>
                  Chemin Photo Voiture <FontAwesomeIcon icon={getSortIconByFieldName('cheminPhotoVoiture')} />
                </th>
                <th className="hand" onClick={sort('conducteur')}>
                  Conducteur <FontAwesomeIcon icon={getSortIconByFieldName('conducteur')} />
                </th>
                <th className="hand" onClick={sort('listePassager')}>
                  Liste Passager <FontAwesomeIcon icon={getSortIconByFieldName('listePassager')} />
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
              {trajetList.map((trajet, i) => (
                <tr key={`entity-${i}`} data-cy="entityTable">
                  <td>
                    <Button tag={Link} to={`/trajet/${trajet.id}`} color="link" size="sm">
                      {trajet.id}
                    </Button>
                  </td>
                  <td>{trajet.lieuDepart}</td>
                  <td>{trajet.lieuArrivee}</td>
                  <td>{trajet.dateDepart ? <TextFormat type="date" value={trajet.dateDepart} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>{trajet.heureDepart ? <TextFormat type="date" value={trajet.heureDepart} format={APP_DATE_FORMAT} /> : null}</td>
                  <td>{trajet.placeDisp}</td>
                  <td>{trajet.cheminPhotoVoiture}</td>
                  <td>{trajet.conducteur}</td>
                  <td>{trajet.listePassager}</td>
                  <td>
                    {trajet.applicationUser ? (
                      <Link to={`/application-user/${trajet.applicationUser.id}`}>{trajet.applicationUser.id}</Link>
                    ) : (
                      ''
                    )}
                  </td>
                  <td>{trajet.utilisateur ? <Link to={`/utilisateur/${trajet.utilisateur.id}`}>{trajet.utilisateur.id}</Link> : ''}</td>
                  <td className="text-end">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`/trajet/${trajet.id}`} color="info" size="sm" data-cy="entityDetailsButton">
                        <FontAwesomeIcon icon="eye" /> <span className="d-none d-md-inline">View</span>
                      </Button>
                      <Button
                        tag={Link}
                        to={`/trajet/${trajet.id}/edit?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`}
                        color="primary"
                        size="sm"
                        data-cy="entityEditButton"
                      >
                        <FontAwesomeIcon icon="pencil-alt" /> <span className="d-none d-md-inline">Edit</span>
                      </Button>
                      <Button
                        onClick={() =>
                          (window.location.href = `/trajet/${trajet.id}/delete?page=${paginationState.activePage}&sort=${paginationState.sort},${paginationState.order}`)
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
          !loading && <div className="alert alert-warning">No Trajets found</div>
        )}
      </div>
      {totalItems ? (
        <div className={trajetList && trajetList.length > 0 ? '' : 'd-none'}>
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

export default Trajet;
