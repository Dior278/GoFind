package com.gofing.myapp.service.mapper;

import com.gofing.myapp.domain.ApplicationUser;
import com.gofing.myapp.domain.Trajet;
import com.gofing.myapp.domain.Utilisateur;
import com.gofing.myapp.service.dto.ApplicationUserDTO;
import com.gofing.myapp.service.dto.TrajetDTO;
import com.gofing.myapp.service.dto.UtilisateurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Trajet} and its DTO {@link TrajetDTO}.
 */
@Mapper(componentModel = "spring")
public interface TrajetMapper extends EntityMapper<TrajetDTO, Trajet> {
    @Mapping(target = "applicationUser", source = "applicationUser", qualifiedByName = "applicationUserId")
    @Mapping(target = "utilisateur", source = "utilisateur", qualifiedByName = "utilisateurId")
    TrajetDTO toDto(Trajet s);

    @Named("applicationUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ApplicationUserDTO toDtoApplicationUserId(ApplicationUser applicationUser);

    @Named("utilisateurId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UtilisateurDTO toDtoUtilisateurId(Utilisateur utilisateur);
}
