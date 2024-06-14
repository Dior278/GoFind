package com.gofing.myapp.service;

import com.gofing.myapp.service.dto.ObjetVoleDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.gofing.myapp.domain.ObjetVole}.
 */
public interface ObjetVoleService {
    /**
     * Save a objetVole.
     *
     * @param objetVoleDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<ObjetVoleDTO> save(ObjetVoleDTO objetVoleDTO);

    /**
     * Updates a objetVole.
     *
     * @param objetVoleDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<ObjetVoleDTO> update(ObjetVoleDTO objetVoleDTO);

    /**
     * Partially updates a objetVole.
     *
     * @param objetVoleDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<ObjetVoleDTO> partialUpdate(ObjetVoleDTO objetVoleDTO);

    /**
     * Get all the objetVoles.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ObjetVoleDTO> findAll(Pageable pageable);

    /**
     * Returns the number of objetVoles available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" objetVole.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<ObjetVoleDTO> findOne(Long id);

    /**
     * Delete the "id" objetVole.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
