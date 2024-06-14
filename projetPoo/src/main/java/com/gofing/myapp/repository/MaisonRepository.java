package com.gofing.myapp.repository;

import com.gofing.myapp.domain.Maison;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the Maison entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MaisonRepository extends ReactiveCrudRepository<Maison, Long>, MaisonRepositoryInternal {
    Flux<Maison> findAllBy(Pageable pageable);

    @Query("SELECT * FROM maison entity WHERE entity.application_user_id = :id")
    Flux<Maison> findByApplicationUser(Long id);

    @Query("SELECT * FROM maison entity WHERE entity.application_user_id IS NULL")
    Flux<Maison> findAllWhereApplicationUserIsNull();

    @Query("SELECT * FROM maison entity WHERE entity.utilisateur_id = :id")
    Flux<Maison> findByUtilisateur(Long id);

    @Query("SELECT * FROM maison entity WHERE entity.utilisateur_id IS NULL")
    Flux<Maison> findAllWhereUtilisateurIsNull();

    @Override
    <S extends Maison> Mono<S> save(S entity);

    @Override
    Flux<Maison> findAll();

    @Override
    Mono<Maison> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface MaisonRepositoryInternal {
    <S extends Maison> Mono<S> save(S entity);

    Flux<Maison> findAllBy(Pageable pageable);

    Flux<Maison> findAll();

    Mono<Maison> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<Maison> findAllBy(Pageable pageable, Criteria criteria);
}
