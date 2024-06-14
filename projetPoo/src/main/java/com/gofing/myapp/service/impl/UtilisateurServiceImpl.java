package com.gofing.myapp.service.impl;

import com.gofing.myapp.repository.UtilisateurRepository;
import com.gofing.myapp.service.UtilisateurService;
import com.gofing.myapp.service.dto.UtilisateurDTO;
import com.gofing.myapp.service.mapper.UtilisateurMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Service Implementation for managing {@link com.gofing.myapp.domain.Utilisateur}.
 */
@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

    private final Logger log = LoggerFactory.getLogger(UtilisateurServiceImpl.class);

    private final UtilisateurRepository utilisateurRepository;

    private final UtilisateurMapper utilisateurMapper;

    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository, UtilisateurMapper utilisateurMapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.utilisateurMapper = utilisateurMapper;
    }

    @Override
    public Mono<UtilisateurDTO> save(UtilisateurDTO utilisateurDTO) {
        log.debug("Request to save Utilisateur : {}", utilisateurDTO);
        return utilisateurRepository.save(utilisateurMapper.toEntity(utilisateurDTO)).map(utilisateurMapper::toDto);
    }

    @Override
    public Mono<UtilisateurDTO> update(UtilisateurDTO utilisateurDTO) {
        log.debug("Request to update Utilisateur : {}", utilisateurDTO);
        return utilisateurRepository.save(utilisateurMapper.toEntity(utilisateurDTO)).map(utilisateurMapper::toDto);
    }

    @Override
    public Mono<UtilisateurDTO> partialUpdate(UtilisateurDTO utilisateurDTO) {
        log.debug("Request to partially update Utilisateur : {}", utilisateurDTO);

        return utilisateurRepository
            .findById(utilisateurDTO.getId())
            .map(existingUtilisateur -> {
                utilisateurMapper.partialUpdate(existingUtilisateur, utilisateurDTO);

                return existingUtilisateur;
            })
            .flatMap(utilisateurRepository::save)
            .map(utilisateurMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<UtilisateurDTO> findAll() {
        log.debug("Request to get all Utilisateurs");
        return utilisateurRepository.findAll().map(utilisateurMapper::toDto);
    }

    public Mono<Long> countAll() {
        return utilisateurRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public Mono<UtilisateurDTO> findOne(Long id) {
        log.debug("Request to get Utilisateur : {}", id);
        return utilisateurRepository.findById(id).map(utilisateurMapper::toDto);
    }

    @Override
    public Mono<Void> delete(Long id) {
        log.debug("Request to delete Utilisateur : {}", id);
        return utilisateurRepository.deleteById(id);
    }
}
