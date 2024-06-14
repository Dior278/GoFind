package com.gofing.myapp.service.mapper;

import com.gofing.myapp.domain.ApplicationUser;
import com.gofing.myapp.domain.Maison;
import com.gofing.myapp.domain.Utilisateur;
import com.gofing.myapp.service.dto.ApplicationUserDTO;
import com.gofing.myapp.service.dto.MaisonDTO;
import com.gofing.myapp.service.dto.UtilisateurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Maison} and its DTO {@link MaisonDTO}.
 */
@Mapper(componentModel = "spring")
public interface MaisonMapper extends EntityMapper<MaisonDTO, Maison> {
    @Mapping(target = "applicationUser", source = "applicationUser", qualifiedByName = "applicationUserId")
    @Mapping(target = "utilisateur", source = "utilisateur", qualifiedByName = "utilisateurId")
    MaisonDTO toDto(Maison s);

    @Named("applicationUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ApplicationUserDTO toDtoApplicationUserId(ApplicationUser applicationUser);

    @Named("utilisateurId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UtilisateurDTO toDtoUtilisateurId(Utilisateur utilisateur);
}
