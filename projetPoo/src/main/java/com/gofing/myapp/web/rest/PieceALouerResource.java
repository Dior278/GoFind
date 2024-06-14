package com.gofing.myapp.web.rest;

import com.gofing.myapp.repository.PieceALouerRepository;
import com.gofing.myapp.service.PieceALouerService;
import com.gofing.myapp.service.dto.PieceALouerDTO;
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
 * REST controller for managing {@link com.gofing.myapp.domain.PieceALouer}.
 */
@RestController
@RequestMapping("/api/piece-a-louers")
public class PieceALouerResource {

    private final Logger log = LoggerFactory.getLogger(PieceALouerResource.class);

    private static final String ENTITY_NAME = "pieceALouer";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PieceALouerService pieceALouerService;

    private final PieceALouerRepository pieceALouerRepository;

    public PieceALouerResource(PieceALouerService pieceALouerService, PieceALouerRepository pieceALouerRepository) {
        this.pieceALouerService = pieceALouerService;
        this.pieceALouerRepository = pieceALouerRepository;
    }

    /**
     * {@code POST  /piece-a-louers} : Create a new pieceALouer.
     *
     * @param pieceALouerDTO the pieceALouerDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new pieceALouerDTO, or with status {@code 400 (Bad Request)} if the pieceALouer has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public Mono<ResponseEntity<PieceALouerDTO>> createPieceALouer(@Valid @RequestBody PieceALouerDTO pieceALouerDTO)
        throws URISyntaxException {
        log.debug("REST request to save PieceALouer : {}", pieceALouerDTO);
        if (pieceALouerDTO.getId() != null) {
            throw new BadRequestAlertException("A new pieceALouer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return pieceALouerService
            .save(pieceALouerDTO)
            .map(result -> {
                try {
                    return ResponseEntity.created(new URI("/api/piece-a-louers/" + result.getId()))
                        .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
                        .body(result);
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
            });
    }

    /**
     * {@code PUT  /piece-a-louers/:id} : Updates an existing pieceALouer.
     *
     * @param id the id of the pieceALouerDTO to save.
     * @param pieceALouerDTO the pieceALouerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pieceALouerDTO,
     * or with status {@code 400 (Bad Request)} if the pieceALouerDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the pieceALouerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public Mono<ResponseEntity<PieceALouerDTO>> updatePieceALouer(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody PieceALouerDTO pieceALouerDTO
    ) throws URISyntaxException {
        log.debug("REST request to update PieceALouer : {}, {}", id, pieceALouerDTO);
        if (pieceALouerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pieceALouerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return pieceALouerRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                return pieceALouerService
                    .update(pieceALouerDTO)
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
     * {@code PATCH  /piece-a-louers/:id} : Partial updates given fields of an existing pieceALouer, field will ignore if it is null
     *
     * @param id the id of the pieceALouerDTO to save.
     * @param pieceALouerDTO the pieceALouerDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated pieceALouerDTO,
     * or with status {@code 400 (Bad Request)} if the pieceALouerDTO is not valid,
     * or with status {@code 404 (Not Found)} if the pieceALouerDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the pieceALouerDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public Mono<ResponseEntity<PieceALouerDTO>> partialUpdatePieceALouer(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody PieceALouerDTO pieceALouerDTO
    ) throws URISyntaxException {
        log.debug("REST request to partial update PieceALouer partially : {}, {}", id, pieceALouerDTO);
        if (pieceALouerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, pieceALouerDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        return pieceALouerRepository
            .existsById(id)
            .flatMap(exists -> {
                if (!exists) {
                    return Mono.error(new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound"));
                }

                Mono<PieceALouerDTO> result = pieceALouerService.partialUpdate(pieceALouerDTO);

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
     * {@code GET  /piece-a-louers} : get all the pieceALouers.
     *
     * @param pageable the pagination information.
     * @param request a {@link ServerHttpRequest} request.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of pieceALouers in body.
     */
    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<List<PieceALouerDTO>>> getAllPieceALouers(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        ServerHttpRequest request
    ) {
        log.debug("REST request to get a page of PieceALouers");
        return pieceALouerService
            .countAll()
            .zipWith(pieceALouerService.findAll(pageable).collectList())
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
     * {@code GET  /piece-a-louers/:id} : get the "id" pieceALouer.
     *
     * @param id the id of the pieceALouerDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the pieceALouerDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<PieceALouerDTO>> getPieceALouer(@PathVariable("id") Long id) {
        log.debug("REST request to get PieceALouer : {}", id);
        Mono<PieceALouerDTO> pieceALouerDTO = pieceALouerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(pieceALouerDTO);
    }

    /**
     * {@code DELETE  /piece-a-louers/:id} : delete the "id" pieceALouer.
     *
     * @param id the id of the pieceALouerDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deletePieceALouer(@PathVariable("id") Long id) {
        log.debug("REST request to delete PieceALouer : {}", id);
        return pieceALouerService
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
