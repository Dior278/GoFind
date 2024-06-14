package com.gofing.myapp.service.mapper;

import com.gofing.myapp.domain.Utilisateur;
import com.gofing.myapp.service.dto.UtilisateurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Utilisateur} and its DTO {@link UtilisateurDTO}.
 */
@Mapper(componentModel = "spring")
public interface UtilisateurMapper extends EntityMapper<UtilisateurDTO, Utilisateur> {}
