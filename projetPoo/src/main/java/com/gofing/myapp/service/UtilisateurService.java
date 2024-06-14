package com.gofing.myapp.service;

import com.gofing.myapp.service.dto.UtilisateurDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.gofing.myapp.domain.Utilisateur}.
 */
public interface UtilisateurService {
    /**
     * Save a utilisateur.
     *
     * @param utilisateurDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<UtilisateurDTO> save(UtilisateurDTO utilisateurDTO);

    /**
     * Updates a utilisateur.
     *
     * @param utilisateurDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<UtilisateurDTO> update(UtilisateurDTO utilisateurDTO);

    /**
     * Partially updates a utilisateur.
     *
     * @param utilisateurDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<UtilisateurDTO> partialUpdate(UtilisateurDTO utilisateurDTO);

    /**
     * Get all the utilisateurs.
     *
     * @return the list of entities.
     */
    Flux<UtilisateurDTO> findAll();

    /**
     * Returns the number of utilisateurs available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" utilisateur.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<UtilisateurDTO> findOne(Long id);

    /**
     * Delete the "id" utilisateur.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
