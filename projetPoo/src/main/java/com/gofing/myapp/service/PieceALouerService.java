package com.gofing.myapp.service;

import com.gofing.myapp.service.dto.PieceALouerDTO;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Interface for managing {@link com.gofing.myapp.domain.PieceALouer}.
 */
public interface PieceALouerService {
    /**
     * Save a pieceALouer.
     *
     * @param pieceALouerDTO the entity to save.
     * @return the persisted entity.
     */
    Mono<PieceALouerDTO> save(PieceALouerDTO pieceALouerDTO);

    /**
     * Updates a pieceALouer.
     *
     * @param pieceALouerDTO the entity to update.
     * @return the persisted entity.
     */
    Mono<PieceALouerDTO> update(PieceALouerDTO pieceALouerDTO);

    /**
     * Partially updates a pieceALouer.
     *
     * @param pieceALouerDTO the entity to update partially.
     * @return the persisted entity.
     */
    Mono<PieceALouerDTO> partialUpdate(PieceALouerDTO pieceALouerDTO);

    /**
     * Get all the pieceALouers.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Flux<PieceALouerDTO> findAll(Pageable pageable);

    /**
     * Returns the number of pieceALouers available.
     * @return the number of entities in the database.
     *
     */
    Mono<Long> countAll();

    /**
     * Get the "id" pieceALouer.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Mono<PieceALouerDTO> findOne(Long id);

    /**
     * Delete the "id" pieceALouer.
     *
     * @param id the id of the entity.
     * @return a Mono to signal the deletion
     */
    Mono<Void> delete(Long id);
}
