package com.gofing.myapp.repository;

import com.gofing.myapp.domain.ObjetVole;
import org.springframework.data.domain.Pageable;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Spring Data R2DBC repository for the ObjetVole entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ObjetVoleRepository extends ReactiveCrudRepository<ObjetVole, Long>, ObjetVoleRepositoryInternal {
    Flux<ObjetVole> findAllBy(Pageable pageable);

    @Query("SELECT * FROM objet_vole entity WHERE entity.application_user_id = :id")
    Flux<ObjetVole> findByApplicationUser(Long id);

    @Query("SELECT * FROM objet_vole entity WHERE entity.application_user_id IS NULL")
    Flux<ObjetVole> findAllWhereApplicationUserIsNull();

    @Query("SELECT * FROM objet_vole entity WHERE entity.utilisateur_id = :id")
    Flux<ObjetVole> findByUtilisateur(Long id);

    @Query("SELECT * FROM objet_vole entity WHERE entity.utilisateur_id IS NULL")
    Flux<ObjetVole> findAllWhereUtilisateurIsNull();

    @Override
    <S extends ObjetVole> Mono<S> save(S entity);

    @Override
    Flux<ObjetVole> findAll();

    @Override
    Mono<ObjetVole> findById(Long id);

    @Override
    Mono<Void> deleteById(Long id);
}

interface ObjetVoleRepositoryInternal {
    <S extends ObjetVole> Mono<S> save(S entity);

    Flux<ObjetVole> findAllBy(Pageable pageable);

    Flux<ObjetVole> findAll();

    Mono<ObjetVole> findById(Long id);
    // this is not supported at the moment because of https://github.com/jhipster/generator-jhipster/issues/18269
    // Flux<ObjetVole> findAllBy(Pageable pageable, Criteria criteria);
}
