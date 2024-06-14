package com.gofing.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Maison.
 */
@Table("maison")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Maison implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "must not be null")
    @Column("adresse")
    private String adresse;

    @Column("chemin_photo_maison")
    private String cheminPhotoMaison;

    @NotNull(message = "must not be null")
    @Column("nbre_piece")
    private Integer nbrePiece;

    @NotNull(message = "must not be null")
    @Column("disponibilite")
    private Boolean disponibilite;

    @NotNull(message = "must not be null")
    @Column("prix_location")
    private BigDecimal prixLocation;

    @NotNull(message = "must not be null")
    @Column("proprietaire")
    private String proprietaire;

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

    public Maison id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public Maison adresse(String adresse) {
        this.setAdresse(adresse);
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCheminPhotoMaison() {
        return this.cheminPhotoMaison;
    }

    public Maison cheminPhotoMaison(String cheminPhotoMaison) {
        this.setCheminPhotoMaison(cheminPhotoMaison);
        return this;
    }

    public void setCheminPhotoMaison(String cheminPhotoMaison) {
        this.cheminPhotoMaison = cheminPhotoMaison;
    }

    public Integer getNbrePiece() {
        return this.nbrePiece;
    }

    public Maison nbrePiece(Integer nbrePiece) {
        this.setNbrePiece(nbrePiece);
        return this;
    }

    public void setNbrePiece(Integer nbrePiece) {
        this.nbrePiece = nbrePiece;
    }

    public Boolean getDisponibilite() {
        return this.disponibilite;
    }

    public Maison disponibilite(Boolean disponibilite) {
        this.setDisponibilite(disponibilite);
        return this;
    }

    public void setDisponibilite(Boolean disponibilite) {
        this.disponibilite = disponibilite;
    }

    public BigDecimal getPrixLocation() {
        return this.prixLocation;
    }

    public Maison prixLocation(BigDecimal prixLocation) {
        this.setPrixLocation(prixLocation);
        return this;
    }

    public void setPrixLocation(BigDecimal prixLocation) {
        this.prixLocation = prixLocation != null ? prixLocation.stripTrailingZeros() : null;
    }

    public String getProprietaire() {
        return this.proprietaire;
    }

    public Maison proprietaire(String proprietaire) {
        this.setProprietaire(proprietaire);
        return this;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }

    public ApplicationUser getApplicationUser() {
        return this.applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
        this.applicationUserId = applicationUser != null ? applicationUser.getId() : null;
    }

    public Maison applicationUser(ApplicationUser applicationUser) {
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

    public Maison utilisateur(Utilisateur utilisateur) {
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
        if (!(o instanceof Maison)) {
            return false;
        }
        return getId() != null && getId().equals(((Maison) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Maison{" +
            "id=" + getId() +
            ", adresse='" + getAdresse() + "'" +
            ", cheminPhotoMaison='" + getCheminPhotoMaison() + "'" +
            ", nbrePiece=" + getNbrePiece() +
            ", disponibilite='" + getDisponibilite() + "'" +
            ", prixLocation=" + getPrixLocation() +
            ", proprietaire='" + getProprietaire() + "'" +
            "}";
    }
}
