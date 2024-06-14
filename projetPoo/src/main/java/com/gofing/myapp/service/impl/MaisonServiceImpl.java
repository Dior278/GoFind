package com.gofing.myapp.service.impl;

import com.gofing.myapp.repository.MaisonRepository;
import com.gofing.myapp.service.MaisonService;
import com.gofing.myapp.service.dto.MaisonDTO;
import com.gofing.myapp.service.mapper.MaisonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.gofing.myapp.domain.Maison}.
 */
@Service
@Transactional
public class MaisonServiceImpl implements MaisonService {

    private final Logger log = LoggerFactory.getLogger(MaisonServiceImpl.class);

    private final MaisonRepository maisonRepository;

    private final MaisonMapper maisonMapper;

    public MaisonServiceImpl(MaisonRepository maisonRepository, MaisonMapper maisonMapper) {
        this.maisonRepository = maisonRepository;
        this.maisonMapper = maisonMapper;
    }

    @Override
    public Mono<MaisonDTO> save(MaisonDTO maisonDTO) {
        log.debug("Request to save Maison : {}", maisonDTO);
        return maisonRepository.save(maisonMapper.toEntity(maisonDTO)).map(maisonMapper::toDto);
    }

    @Override
    public Mono<MaisonDTO> update(MaisonDTO maisonDTO) {
        log.debug("Request to update Maison : {}", maisonDTO);
        return maisonRepository.save(maisonMapper.toEntity(maisonDTO)).map(maisonMapper::toDto);
    }

    @Override
    public Mono<MaisonDTO> partialUpdate(MaisonDTO maisonDTO) {
        log.debug("Request to partially update Maison : {}", maisonDTO);

        return maisonRepository
            .findById(maisonDTO.getId())
            .map(existingMaison -> {
                maisonMapper.partialUpdate(existingMaison, maisonDTO);

                return existingMaison;
            })
            .flatMap(maisonRepository::save)
            .map(maisonMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<MaisonDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Maisons");
        return maisonRepository.findAllBy(pageable).map(maisonMapper::toDto);
    }

    public Mono<Long> countAll() {
        return maisonRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<MaisonDTO> findOne(Long id) {
        log.debug("Request to get Maison : {}", id);
        return maisonRepository.findById(id).map(maisonMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Maison : {}", id);
        return maisonRepository.deleteById(id);
    }
}
