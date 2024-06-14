package com.gofing.myapp.service.impl;

import com.gofing.myapp.repository.TrajetRepository;
import com.gofing.myapp.service.TrajetService;
import com.gofing.myapp.service.dto.TrajetDTO;
import com.gofing.myapp.service.mapper.TrajetMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.gofing.myapp.domain.Trajet}.
 */
@Service
@Transactional
public class TrajetServiceImpl implements TrajetService {

    private final Logger log = LoggerFactory.getLogger(TrajetServiceImpl.class);

    private final TrajetRepository trajetRepository;

    private final TrajetMapper trajetMapper;

    public TrajetServiceImpl(TrajetRepository trajetRepository, TrajetMapper trajetMapper) {
        this.trajetRepository = trajetRepository;
        this.trajetMapper = trajetMapper;
    }

    @Override
    public Mono<TrajetDTO> save(TrajetDTO trajetDTO) {
        log.debug("Request to save Trajet : {}", trajetDTO);
        return trajetRepository.save(trajetMapper.toEntity(trajetDTO)).map(trajetMapper::toDto);
    }

    @Override
    public Mono<TrajetDTO> update(TrajetDTO trajetDTO) {
        log.debug("Request to update Trajet : {}", trajetDTO);
        return trajetRepository.save(trajetMapper.toEntity(trajetDTO)).map(trajetMapper::toDto);
    }

    @Override
    public Mono<TrajetDTO> partialUpdate(TrajetDTO trajetDTO) {
        log.debug("Request to partially update Trajet : {}", trajetDTO);

        return trajetRepository
            .findById(trajetDTO.getId())
            .map(existingTrajet -> {
                trajetMapper.partialUpdate(existingTrajet, trajetDTO);

                return existingTrajet;
            })
            .flatMap(trajetRepository::save)
            .map(trajetMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<TrajetDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Trajets");
        return trajetRepository.findAllBy(pageable).map(trajetMapper::toDto);
    }

    public Mono<Long> countAll() {
        return trajetRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<TrajetDTO> findOne(Long id) {
        log.debug("Request to get Trajet : {}", id);
        return trajetRepository.findById(id).map(trajetMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Trajet : {}", id);
        return trajetRepository.deleteById(id);
    }
}
