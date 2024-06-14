package com.gofing.myapp.service.impl;

import com.gofing.myapp.repository.ObjetVoleRepository;
import com.gofing.myapp.service.ObjetVoleService;
import com.gofing.myapp.service.dto.ObjetVoleDTO;
import com.gofing.myapp.service.mapper.ObjetVoleMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.gofing.myapp.domain.ObjetVole}.
 */
@Service
@Transactional
public class ObjetVoleServiceImpl implements ObjetVoleService {

    private final Logger log = LoggerFactory.getLogger(ObjetVoleServiceImpl.class);

    private final ObjetVoleRepository objetVoleRepository;

    private final ObjetVoleMapper objetVoleMapper;

    public ObjetVoleServiceImpl(ObjetVoleRepository objetVoleRepository, ObjetVoleMapper objetVoleMapper) {
        this.objetVoleRepository = objetVoleRepository;
        this.objetVoleMapper = objetVoleMapper;
    }

    @Override
    public Mono<ObjetVoleDTO> save(ObjetVoleDTO objetVoleDTO) {
        log.debug("Request to save ObjetVole : {}", objetVoleDTO);
        return objetVoleRepository.save(objetVoleMapper.toEntity(objetVoleDTO)).map(objetVoleMapper::toDto);
    }

    @Override
    public Mono<ObjetVoleDTO> update(ObjetVoleDTO objetVoleDTO) {
        log.debug("Request to update ObjetVole : {}", objetVoleDTO);
        return objetVoleRepository.save(objetVoleMapper.toEntity(objetVoleDTO)).map(objetVoleMapper::toDto);
    }

    @Override
    public Mono<ObjetVoleDTO> partialUpdate(ObjetVoleDTO objetVoleDTO) {
        log.debug("Request to partially update ObjetVole : {}", objetVoleDTO);

        return objetVoleRepository
            .findById(objetVoleDTO.getId())
            .map(existingObjetVole -> {
                objetVoleMapper.partialUpdate(existingObjetVole, objetVoleDTO);

                return existingObjetVole;
            })
            .flatMap(objetVoleRepository::save)
            .map(objetVoleMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ObjetVoleDTO> findAll(Pageable pageable) {
        log.debug("Request to get all ObjetVoles");
        return objetVoleRepository.findAllBy(pageable).map(objetVoleMapper::toDto);
    }

    public Mono<Long> countAll() {
        return objetVoleRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<ObjetVoleDTO> findOne(Long id) {
        log.debug("Request to get ObjetVole : {}", id);
        return objetVoleRepository.findById(id).map(objetVoleMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete ObjetVole : {}", id);
        return objetVoleRepository.deleteById(id);
    }
}
