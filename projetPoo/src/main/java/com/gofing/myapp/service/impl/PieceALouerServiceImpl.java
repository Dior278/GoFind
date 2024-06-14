package com.gofing.myapp.service.impl;

import com.gofing.myapp.repository.PieceALouerRepository;
import com.gofing.myapp.service.PieceALouerService;
import com.gofing.myapp.service.dto.PieceALouerDTO;
import com.gofing.myapp.service.mapper.PieceALouerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.gofing.myapp.domain.PieceALouer}.
 */
@Service
@Transactional
public class PieceALouerServiceImpl implements PieceALouerService {

    private final Logger log = LoggerFactory.getLogger(PieceALouerServiceImpl.class);

    private final PieceALouerRepository pieceALouerRepository;

    private final PieceALouerMapper pieceALouerMapper;

    public PieceALouerServiceImpl(PieceALouerRepository pieceALouerRepository, PieceALouerMapper pieceALouerMapper) {
        this.pieceALouerRepository = pieceALouerRepository;
        this.pieceALouerMapper = pieceALouerMapper;
    }

    @Override
    public Mono<PieceALouerDTO> save(PieceALouerDTO pieceALouerDTO) {
        log.debug("Request to save PieceALouer : {}", pieceALouerDTO);
        return pieceALouerRepository.save(pieceALouerMapper.toEntity(pieceALouerDTO)).map(pieceALouerMapper::toDto);
    }

    @Override
    public Mono<PieceALouerDTO> update(PieceALouerDTO pieceALouerDTO) {
        log.debug("Request to update PieceALouer : {}", pieceALouerDTO);
        return pieceALouerRepository.save(pieceALouerMapper.toEntity(pieceALouerDTO)).map(pieceALouerMapper::toDto);
    }

    @Override
    public Mono<PieceALouerDTO> partialUpdate(PieceALouerDTO pieceALouerDTO) {
        log.debug("Request to partially update PieceALouer : {}", pieceALouerDTO);

        return pieceALouerRepository
            .findById(pieceALouerDTO.getId())
            .map(existingPieceALouer -> {
                pieceALouerMapper.partialUpdate(existingPieceALouer, pieceALouerDTO);

                return existingPieceALouer;
            })
            .flatMap(pieceALouerRepository::save)
            .map(pieceALouerMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<PieceALouerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PieceALouers");
        return pieceALouerRepository.findAllBy(pageable).map(pieceALouerMapper::toDto);
    }

    public Mono<Long> countAll() {
        return pieceALouerRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<PieceALouerDTO> findOne(Long id) {
        log.debug("Request to get PieceALouer : {}", id);
        return pieceALouerRepository.findById(id).map(pieceALouerMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete PieceALouer : {}", id);
        return pieceALouerRepository.deleteById(id);
    }
}
