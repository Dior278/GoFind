package com.gofing.myapp.service.impl;

import com.gofing.myapp.repository.ApplicationUserRepository;
import com.gofing.myapp.service.ApplicationUserService;
import com.gofing.myapp.service.dto.ApplicationUserDTO;
import com.gofing.myapp.service.mapper.ApplicationUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.gofing.myapp.domain.ApplicationUser}.
 */
@Service
@Transactional
public class ApplicationUserServiceImpl implements ApplicationUserService {

    private final Logger log = LoggerFactory.getLogger(ApplicationUserServiceImpl.class);

    private final ApplicationUserRepository applicationUserRepository;

    private final ApplicationUserMapper applicationUserMapper;

    public ApplicationUserServiceImpl(ApplicationUserRepository applicationUserRepository, ApplicationUserMapper applicationUserMapper) {
        this.applicationUserRepository = applicationUserRepository;
        this.applicationUserMapper = applicationUserMapper;
    }

    @Override
    public Mono<ApplicationUserDTO> save(ApplicationUserDTO applicationUserDTO) {
        log.debug("Request to save ApplicationUser : {}", applicationUserDTO);
        return applicationUserRepository.save(applicationUserMapper.toEntity(applicationUserDTO)).map(applicationUserMapper::toDto);
    }

    @Override
    public Mono<ApplicationUserDTO> update(ApplicationUserDTO applicationUserDTO) {
        log.debug("Request to update ApplicationUser : {}", applicationUserDTO);
        return applicationUserRepository.save(applicationUserMapper.toEntity(applicationUserDTO)).map(applicationUserMapper::toDto);
    }

    @Override
    public Mono<ApplicationUserDTO> partialUpdate(ApplicationUserDTO applicationUserDTO) {
        log.debug("Request to partially update ApplicationUser : {}", applicationUserDTO);

        return applicationUserRepository
            .findById(applicationUserDTO.getId())
            .map(existingApplicationUser -> {
                applicationUserMapper.partialUpdate(existingApplicationUser, applicationUserDTO);

                return existingApplicationUser;
            })
            .flatMap(applicationUserRepository::save)
            .map(applicationUserMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<ApplicationUserDTO> findAll() {
        log.debug("Request to get all ApplicationUsers");
        return applicationUserRepository.findAll().map(applicationUserMapper::toDto);
    }

    public Flux<ApplicationUserDTO> findAllWithEagerRelationships(Pageable pageable) {
        return applicationUserRepository.findAllWithEagerRelationships(pageable).map(applicationUserMapper::toDto);
    }

    public Mono<Long> countAll() {
        return applicationUserRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<ApplicationUserDTO> findOne(Long id) {
        log.debug("Request to get ApplicationUser : {}", id);
        return applicationUserRepository.findOneWithEagerRelationships(id).map(applicationUserMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete ApplicationUser : {}", id);
        return applicationUserRepository.deleteById(id);
    }
}
