package com.gofing.myapp.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.gofing.myapp.domain.Utilisateur} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class UtilisateurDTO implements Serializable {

    private Long id;

    private String nom;

    private String prenom;

    private String email;

    private String numeroTel;

    private String motDePasse;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTel() {
        return numeroTel;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UtilisateurDTO)) {
            return false;
        }

        UtilisateurDTO utilisateurDTO = (UtilisateurDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, utilisateurDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "UtilisateurDTO{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", numeroTel='" + getNumeroTel() + "'" +
            ", motDePasse='" + getMotDePasse() + "'" +
            "}";
    }
}
