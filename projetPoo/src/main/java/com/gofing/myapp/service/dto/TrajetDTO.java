package com.gofing.myapp.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.gofing.myapp.domain.Trajet} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class TrajetDTO implements Serializable {

    private Long id;

    @NotNull(message = "must not be null")
    private String lieuDepart;

    @NotNull(message = "must not be null")
    private String lieuArrivee;

    @NotNull(message = "must not be null")
    private Instant dateDepart;

    @NotNull(message = "must not be null")
    private Instant heureDepart;

    @NotNull(message = "must not be null")
    private Integer placeDisp;

    private String cheminPhotoVoiture;

    @NotNull(message = "must not be null")
    private String conducteur;

    private String listePassager;

    private ApplicationUserDTO applicationUser;

    private UtilisateurDTO utilisateur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieuDepart() {
        return lieuDepart;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArrivee() {
        return lieuArrivee;
    }

    public void setLieuArrivee(String lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
    }

    public Instant getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(Instant dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Instant getHeureDepart() {
        return heureDepart;
    }

    public void setHeureDepart(Instant heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Integer getPlaceDisp() {
        return placeDisp;
    }

    public void setPlaceDisp(Integer placeDisp) {
        this.placeDisp = placeDisp;
    }

    public String getCheminPhotoVoiture() {
        return cheminPhotoVoiture;
    }

    public void setCheminPhotoVoiture(String cheminPhotoVoiture) {
        this.cheminPhotoVoiture = cheminPhotoVoiture;
    }

    public String getConducteur() {
        return conducteur;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public String getListePassager() {
        return listePassager;
    }

    public void setListePassager(String listePassager) {
        this.listePassager = listePassager;
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
        if (!(o instanceof TrajetDTO)) {
            return false;
        }

        TrajetDTO trajetDTO = (TrajetDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, trajetDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "TrajetDTO{" +
            "id=" + getId() +
            ", lieuDepart='" + getLieuDepart() + "'" +
            ", lieuArrivee='" + getLieuArrivee() + "'" +
            ", dateDepart='" + getDateDepart() + "'" +
            ", heureDepart='" + getHeureDepart() + "'" +
            ", placeDisp=" + getPlaceDisp() +
            ", cheminPhotoVoiture='" + getCheminPhotoVoiture() + "'" +
            ", conducteur='" + getConducteur() + "'" +
            ", listePassager='" + getListePassager() + "'" +
            ", applicationUser=" + getApplicationUser() +
            ", utilisateur=" + getUtilisateur() +
            "}";
    }
}
