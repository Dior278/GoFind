package com.gofing.myapp.service.mapper;

import com.gofing.myapp.domain.ApplicationUser;
import com.gofing.myapp.domain.PieceALouer;
import com.gofing.myapp.domain.Utilisateur;
import com.gofing.myapp.service.dto.ApplicationUserDTO;
import com.gofing.myapp.service.dto.PieceALouerDTO;
import com.gofing.myapp.service.dto.UtilisateurDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link PieceALouer} and its DTO {@link PieceALouerDTO}.
 */
@Mapper(componentModel = "spring")
public interface PieceALouerMapper extends EntityMapper<PieceALouerDTO, PieceALouer> {
    @Mapping(target = "applicationUser", source = "applicationUser", qualifiedByName = "applicationUserId")
    @Mapping(target = "utilisateur", source = "utilisateur", qualifiedByName = "utilisateurId")
    PieceALouerDTO toDto(PieceALouer s);

    @Named("applicationUserId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    ApplicationUserDTO toDtoApplicationUserId(ApplicationUser applicationUser);

    @Named("utilisateurId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UtilisateurDTO toDtoUtilisateurId(Utilisateur utilisateur);
}
