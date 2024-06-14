package com.gofing.myapp.service;

import com.gofing.myapp.service.dto.TrajetDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.gofing.myapp.domain.Trajet}.
 */
public interface TrajetService {
    /**
     * Save a trajet.
     *
     * @param trajetDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<TrajetDTO> save(TrajetDTO trajetDTO);

    /**
     * Updates a trajet.
     *
     * @param trajetDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<TrajetDTO> update(TrajetDTO trajetDTO);

    /**
     * Partially updates a trajet.
     *
     * @param trajetDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<TrajetDTO> partialUpdate(TrajetDTO trajetDTO);

    /**
     * Get all the trajets.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<TrajetDTO> findAll(Pageable pageable);

    /**
     * Returns the number of trajets available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" trajet.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<TrajetDTO> findOne(Long id);

    /**
     * Delete the "id" trajet.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
