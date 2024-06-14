package com.gofing.myapp.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * A DTO for the {@link com.gofing.myapp.domain.PieceALouer} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class PieceALouerDTO implements Serializable {

    private Long id;

    @NotNull(message = "must not be null")
    private String adresse;

    private String cheminPhotoPiece;

    @NotNull(message = "must not be null")
    private Boolean disponibilite;

    @NotNull(message = "must not be null")
    private BigDecimal prixLocation;

    @NotNull(message = "must not be null")
    private String proprietaire;

    private ApplicationUserDTO applicationUser;

    private UtilisateurDTO utilisateur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCheminPhotoPiece() {
        return cheminPhotoPiece;
    }

    public void setCheminPhotoPiece(String cheminPhotoPiece) {
        this.cheminPhotoPiece = cheminPhotoPiece;
    }

    public Boolean getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public BigDecimal getPrixLocation() {
        return prixLocation;
    }

    public void setPrixLocation(BigDecimal prixLocation) {
        this.prixLocation = prixLocation;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public ApplicationUserDTO getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(ApplicationUserDTO applicationUser) {
        this.applicationUser = applicationUser;
    }

    public UtilisateurDTO getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(UtilisateurDTO utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PieceALouerDTO)) {
            return false;
        }

        PieceALouerDTO pieceALouerDTO = (PieceALouerDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, pieceALouerDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PieceALouerDTO{" +
            "id=" + getId() +
            ", adresse='" + getAdresse() + "'" +
            ", cheminPhotoPiece='" + getCheminPhotoPiece() + "'" +
            ", disponibilite='" + getDisponibilite() + "'" +
            ", prixLocation=" + getPrixLocation() +
            ", proprietaire='" + getProprietaire() + "'" +
            ", applicationUser=" + getApplicationUser() +
            ", utilisateur=" + getUtilisateur() +
            "}";
    }
}
