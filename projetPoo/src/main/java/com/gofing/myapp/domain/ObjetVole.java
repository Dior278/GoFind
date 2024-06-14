package com.gofing.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.Instant;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A ObjetVole.
 */
@Table("objet_vole")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ObjetVole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "must not be null")
    @Column("nom")
    private String nom;

    @NotNull(message = "must not be null")
    @Column("type")
    private String type;

    @NotNull(message = "must not be null")
    @Column("date_vole")
    private Instant dateVole;

    @Column("chemin_photo_objet")
    private String cheminPhotoObjet;

    @Column("chemin_facture")
    private String cheminFacture;

    @NotNull(message = "must not be null")
    @Column("etat")
    private String etat;

    @NotNull(message = "must not be null")
    @Column("adresse_proprietaire")
    private String adresseProprietaire;

    @Transient
    @JsonIgnoreProperties(value = { "internalUser", "trajets", "objetVoles", "maisons", "pieceALouers" }, allowSetters = true)
    private ApplicationUser applicationUser;

    @Transient
    @JsonIgnoreProperties(value = { "trajets", "objetVoles", "maisons", "pieceALouers" }, allowSetters = true)
    private Utilisateur utilisateur;

    @Column("application_user_id")
    private Long applicationUserId;

    @Column("utilisateur_id")
    private Long utilisateurId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ObjetVole id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public ObjetVole nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return this.type;
    }

    public ObjetVole type(String type) {
        this.setType(type);
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Instant getDateVole() {
        return this.dateVole;
    }

    public ObjetVole dateVole(Instant dateVole) {
        this.setDateVole(dateVole);
        return this;
    }

    public void setDateVole(Instant dateVole) {
        this.dateVole = dateVole;
    }

    public String getCheminPhotoObjet() {
        return this.cheminPhotoObjet;
    }

    public ObjetVole cheminPhotoObjet(String cheminPhotoObjet) {
        this.setCheminPhotoObjet(cheminPhotoObjet);
        return this;
    }

    public void setCheminPhotoObjet(String cheminPhotoObjet) {
        this.cheminPhotoObjet = cheminPhotoObjet;
    }

    public String getCheminFacture() {
        return this.cheminFacture;
    }

    public ObjetVole cheminFacture(String cheminFacture) {
        this.setCheminFacture(cheminFacture);
        return this;
    }

    public void setCheminFacture(String cheminFacture) {
        this.cheminFacture = cheminFacture;
    }

    public String getEtat() {
        return this.etat;
    }

    public ObjetVole etat(String etat) {
        this.setEtat(etat);
        return this;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getAdresseProprietaire() {
        return this.adresseProprietaire;
    }

    public ObjetVole adresseProprietaire(String adresseProprietaire) {
        this.setAdresseProprietaire(adresseProprietaire);
        return this;
    }

    public void setAdresseProprietaire(String adresseProprietaire) {
        this.adresseProprietaire = adresseProprietaire;
    }

    public ApplicationUser getApplicationUser() {
        return this.applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
        this.applicationUserId = applicationUser != null ? applicationUser.getId() : null;
    }

    public ObjetVole applicationUser(ApplicationUser applicationUser) {
        this.setApplicationUser(applicationUser);
        return this;
    }

    public Utilisateur getUtilisateur() {
        return this.utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        this.utilisateurId = utilisateur != null ? utilisateur.getId() : null;
    }

    public ObjetVole utilisateur(Utilisateur utilisateur) {
        this.setUtilisateur(utilisateur);
        return this;
    }

    public Long getApplicationUserId() {
        return this.applicationUserId;
    }

    public void setApplicationUserId(Long applicationUser) {
        this.applicationUserId = applicationUser;
    }

    public Long getUtilisateurId() {
        return this.utilisateurId;
    }

    public void setUtilisateurId(Long utilisateur) {
        this.utilisateurId = utilisateur;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ObjetVole)) {
            return false;
        }
        return getId() != null && getId().equals(((ObjetVole) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ObjetVole{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", type='" + getType() + "'" +
            ", dateVole='" + getDateVole() + "'" +
            ", cheminPhotoObjet='" + getCheminPhotoObjet() + "'" +
            ", cheminFacture='" + getCheminFacture() + "'" +
            ", etat='" + getEtat() + "'" +
            ", adresseProprietaire='" + getAdresseProprietaire() + "'" +
            "}";
    }
}
