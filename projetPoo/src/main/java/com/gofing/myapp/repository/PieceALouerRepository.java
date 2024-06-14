package com.gofing.myapp.repository;

import com.gofing.myapp.domain.PieceALouer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the PieceALouer entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PieceALouerRepository extends ReactiveCrudRepository<PieceALouer, Long>, PieceALouerRepositoryInternal {
    Flux<PieceALouer> findAllBy(Pageable pageable);

    @Query("SELECT * FROM piece_a_louer entity WHERE entity.application_user_id = :id")
    Flux<PieceALouer> findByApplicationUser(Long id);

    @Query("SELECT * FROM piece_a_louer entity WHERE entity.application_user_id IS NULL")
    Flux<PieceALouer> findAllWhereApplicationUserIsNull();

    @Query("SELECT * FROM piece_a_louer entity WHERE entity.utilisateur_id = :id")
    Flux<PieceALouer> findByUtilisateur(Long id);

    @Query("SELECT * FROM piece_a_louer entity WHERE entity.utilisateur_id IS NULL")
    Flux<PieceALouer> findAllWhereUtilisateurIsNull();

    @Override
    <S extends PieceALouer> Mono<S> save(S entity);

    @Override
    Flux<PieceALouer> findAll();

    @Override
    Mono<PieceALouer> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface PieceALouerRepositoryInternal {
    <S extends PieceALouer> Mono<S> save(S entity);

    Flux<PieceALouer> findAllBy(Pageable pageable);

    Flux<PieceALouer> findAll();

    Mono<PieceALouer> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<PieceALouer> findAllBy(Pageable pageable, Criteria criteria);
}
