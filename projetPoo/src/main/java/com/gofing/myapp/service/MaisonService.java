package com.gofing.myapp.service;

import com.gofing.myapp.service.dto.MaisonDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.gofing.myapp.domain.Maison}.
 */
public interface MaisonService {
    /**
     * Save a maison.
     *
     * @param maisonDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<MaisonDTO> save(MaisonDTO maisonDTO);

    /**
     * Updates a maison.
     *
     * @param maisonDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<MaisonDTO> update(MaisonDTO maisonDTO);

    /**
     * Partially updates a maison.
     *
     * @param maisonDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<MaisonDTO> partialUpdate(MaisonDTO maisonDTO);

    /**
     * Get all the maisons.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<MaisonDTO> findAll(Pageable pageable);

    /**
     * Returns the number of maisons available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" maison.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<MaisonDTO> findOne(Long id);

    /**
     * Delete the "id" maison.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
