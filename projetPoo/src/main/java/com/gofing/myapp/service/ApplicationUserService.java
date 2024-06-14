package com.gofing.myapp.service;

import com.gofing.myapp.service.dto.ApplicationUserDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.gofing.myapp.domain.ApplicationUser}.
 */
public interface ApplicationUserService {
    /**
     * Save a applicationUser.
     *
     * @param applicationUserDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<ApplicationUserDTO> save(ApplicationUserDTO applicationUserDTO);

    /**
     * Updates a applicationUser.
     *
     * @param applicationUserDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<ApplicationUserDTO> update(ApplicationUserDTO applicationUserDTO);

    /**
     * Partially updates a applicationUser.
     *
     * @param applicationUserDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<ApplicationUserDTO> partialUpdate(ApplicationUserDTO applicationUserDTO);

    /**
     * Get all the applicationUsers.
     *
     * @return the list of entities.
     */
    Flux<ApplicationUserDTO> findAll();

    /**
     * Get all the applicationUsers with eager load of many-to-many relationships.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<ApplicationUserDTO> findAllWithEagerRelationships(Pageable pageable);

    /**
     * Returns the number of applicationUsers available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" applicationUser.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<ApplicationUserDTO> findOne(Long id);

    /**
     * Delete the "id" applicationUser.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
