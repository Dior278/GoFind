package com.gofing.myapp.service.mapper;

import com.gofing.myapp.domain.ApplicationUser;
import com.gofing.myapp.domain.ObjetVole;
import com.gofing.myapp.domain.Utilisateur;
import com.gofing.myapp.service.dto.ApplicationUserDTO;
import com.gofing.myapp.service.dto.ObjetVoleDTO;
import com.gofing.myapp.service.dto.UtilisateurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link ObjetVole} and its DTO {@link ObjetVoleDTO}.
 */
@Mapper(componentModel = "spring")
public interface ObjetVoleMapper extends EntityMapper<ObjetVoleDTO, ObjetVole> {
    @Mapping(target = "applicationUser", source = "applicationUser", qualifiedByName = "applicationUserId")
    @Mapping(target = "utilisateur", source = "utilisateur", qualifiedByName = "utilisateurId")
    ObjetVoleDTO toDto(ObjetVole s);

    @Named("applicationUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ApplicationUserDTO toDtoApplicationUserId(ApplicationUser applicationUser);

    @Named("utilisateurId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UtilisateurDTO toDtoUtilisateurId(Utilisateur utilisateur);
}
