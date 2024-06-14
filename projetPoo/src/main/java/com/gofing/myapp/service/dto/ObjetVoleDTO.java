package com.gofing.myapp.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link com.gofing.myapp.domain.ObjetVole} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ObjetVoleDTO implements Serializable {

    private Long id;

    @NotNull(message = "must not be null")
    private String nom;

    @NotNull(message = "must not be null")
    private String type;

    @NotNull(message = "must not be null")
    private Instant dateVole;

    private String cheminPhotoObjet;

    private String cheminFacture;

    @NotNull(message = "must not be null")
    private String etat;

    @NotNull(message = "must not be null")
    private String adresseProprietaire;

    private ApplicationUserDTO applicationUser;

    private UtilisateurDTO utilisateur;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getDateVole() {
        return dateVole;
    }

    public void setDateVole(Instant dateVole) {
        this.dateVole = dateVole;
    }

    public String getCheminPhotoObjet() {
        return cheminPhotoObjet;
    }

    public void setCheminPhotoObjet(String cheminPhotoObjet) {
        this.cheminPhotoObjet = cheminPhotoObjet;
    }

    public String getCheminFacture() {
        return cheminFacture;
    }

    public void setCheminFacture(String cheminFacture) {
        this.cheminFacture = cheminFacture;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getAdresseProprietaire() {
        return adresseProprietaire;
    }

    public void setAdresseProprietaire(String adresseProprietaire) {
        this.adresseProprietaire = adresseProprietaire;
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
        if (!(o instanceof ObjetVoleDTO)) {
            return false;
        }

        ObjetVoleDTO objetVoleDTO = (ObjetVoleDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, objetVoleDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ObjetVoleDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", type='" + getType() + "'" +
            ", dateVole='" + getDateVole() + "'" +
            ", cheminPhotoObjet='" + getCheminPhotoObjet() + "'" +
            ", cheminFacture='" + getCheminFacture() + "'" +
            ", etat='" + getEtat() + "'" +
            ", adresseProprietaire='" + getAdresseProprietaire() + "'" +
            ", applicationUser=" + getApplicationUser() +
            ", utilisateur=" + getUtilisateur() +
            "}";
    }
}
