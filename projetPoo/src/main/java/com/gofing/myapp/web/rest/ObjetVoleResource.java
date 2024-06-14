package com.gofing.myapp.web.rest;

import com.gofing.myapp.repository.ObjetVoleRepository;
import com.gofing.myapp.service.ObjetVoleService;
import com.gofing.myapp.service.dto.ObjetVoleDTO;
import com.gofing.myapp.web.rest.errors.BadRequestAlertException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.ForwardedHeaderUtils;
import reactor.core.publisher.Mono;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.reactive.ResponseUtil;

/**
 * REST controller for managing {@link com.gofing.myapp.domain.ObjetVole}.
 */
@RestController
@RequestMapping("/api/objet-voles")
public class ObjetVoleResource {

    private final Logger log = LoggerFactory.getLogger(ObjetVoleResource.class);

    private static final String ENTITY_NAME = "objetVole";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ObjetVoleService objetVoleService;

    private final ObjetVoleRepository objetVoleRepository;

    public ObjetVoleResource(ObjetVoleService objetVoleService, ObjetVoleRepository objetVoleRepository) {
        this.objetVoleService = objetVoleService;
        this.objetVoleRepository = objetVoleRepository;
    }

    /**
     * {@code POST  /objet-voles} : Create a new objetVole.
     *
     * @param objetVoleDTO the objetVoleDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new objetVoleDTO, or with status {@code 400 (Bad Request)} if the objetVole has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public Mono<ResponseEntity<ObjetVoleDTO>> createObjetVole(@Valid @RequestBody ObjetVoleDTO objetVoleDTO) throws URISyntaxException {
        log.debug("REST request to save ObjetVole : {}", objetVoleDTO);
        if (objetVoleDTO.getId() != null) {
            throw new BadRequestAlertException("A new objetVole cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return objetVoleService
            .save(objetVoleDTO)
            .map(result -> {
                try {
                    return ResponseEntity.created(new URI("/api/objet-voles/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /objet-voles/:id} : Updates an existing objetVole.
     *
     * @param id the id of the objetVoleDTO to save.
     * @param objetVoleDTO the objetVoleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated objetVoleDTO,
     * or with status {@code 400 (Bad Request)} if the objetVoleDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the objetVoleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<ObjetVoleDTO>> updateObjetVole(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody ObjetVoleDTO objetVoleDTO
    ) throws URISyntaxException {
        log.debug("REST request to update ObjetVole : {}, {}", id, objetVoleDTO);
        if (objetVoleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, objetVoleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return objetVoleRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return objetVoleService
                    .update(objetVoleDTO)
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(
                        result ->
                            ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                                .body(result)
                    );
            });
    }

    /**
     * {@code PATCH  /objet-voles/:id} : Partial updates given fields of an existing objetVole, field will ignore if it is null
     *
     * @param id the id of the objetVoleDTO to save.
     * @param objetVoleDTO the objetVoleDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated objetVoleDTO,
     * or with status {@code 400 (Bad Request)} if the objetVoleDTO is not valid,
     * or with status {@code 404 (Not Found)} if the objetVoleDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the objetVoleDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<ObjetVoleDTO>> partialUpdateObjetVole(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody ObjetVoleDTO objetVoleDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update ObjetVole partially : {}, {}", id, objetVoleDTO);
        if (objetVoleDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, objetVoleDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return objetVoleRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<ObjetVoleDTO> result = objetVoleService.partialUpdate(objetVoleDTO);

                return result
                    .switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND)))
                    .map(
                        res ->
                            ResponseEntity.ok()
                                .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, res.getId().toString()))
                                .body(res)
                    );
            });
    }

    /**
     * {@code GET  /objet-voles} : get all the objetVoles.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of objetVoles in body.
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<ObjetVoleDTO>>> getAllObjetVoles(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of ObjetVoles");
        return objetVoleService
            .countAll()
            .zipWith(objetVoleService.findAll(pageable).collectList())
            .map(
                countWithEntities ->
                    ResponseEntity.ok()
                        .headers(
                            PaginationUtil.generatePaginationHttpHeaders(
                                ForwardedHeaderUtils.adaptFromForwardedHeaders(request.getURI(), request.getHeaders()),
                                new PageImpl<>(countWithEntities.getT2(), pageable, countWithEntities.getT1())
                            )
                        )
                        .body(countWithEntities.getT2())
            );
    }

    /**
     * {@code GET  /objet-voles/:id} : get the "id" objetVole.
     *
     * @param id the id of the objetVoleDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the objetVoleDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ObjetVoleDTO>> getObjetVole(@PathVariable("id") Long id) {
        log.debug("REST request to get ObjetVole : {}", id);
        Mono<ObjetVoleDTO> objetVoleDTO = objetVoleService.findOne(id);
        return ResponseUtil.wrapOrNotFound(objetVoleDTO);
    }

    /**
     * {@code DELETE  /objet-voles/:id} : delete the "id" objetVole.
     *
     * @param id the id of the objetVoleDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteObjetVole(@PathVariable("id") Long id) {
        log.debug("REST request to delete ObjetVole : {}", id);
        return objetVoleService
            .delete(id)
            .then(
                Mono.just(
                    ResponseEntity.noContent()
                        .headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString()))
                        .build()
                )
            );
    }
}
