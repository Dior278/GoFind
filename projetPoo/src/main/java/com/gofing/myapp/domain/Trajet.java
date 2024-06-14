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
 * A Trajet.
 */
@Table("trajet")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Trajet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @NotNull(message = "must not be null")
    @Column("lieu_depart")
    private String lieuDepart;

    @NotNull(message = "must not be null")
    @Column("lieu_arrivee")
    private String lieuArrivee;

    @NotNull(message = "must not be null")
    @Column("date_depart")
    private Instant dateDepart;

    @NotNull(message = "must not be null")
    @Column("heure_depart")
    private Instant heureDepart;

    @NotNull(message = "must not be null")
    @Column("place_disp")
    private Integer placeDisp;

    @Column("chemin_photo_voiture")
    private String cheminPhotoVoiture;

    @NotNull(message = "must not be null")
    @Column("conducteur")
    private String conducteur;

    @Column("liste_passager")
    private String listePassager;

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

    public Trajet id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieuDepart() {
        return this.lieuDepart;
    }

    public Trajet lieuDepart(String lieuDepart) {
        this.setLieuDepart(lieuDepart);
        return this;
    }

    public void setLieuDepart(String lieuDepart) {
        this.lieuDepart = lieuDepart;
    }

    public String getLieuArrivee() {
        return this.lieuArrivee;
    }

    public Trajet lieuArrivee(String lieuArrivee) {
        this.setLieuArrivee(lieuArrivee);
        return this;
    }

    public void setLieuArrivee(String lieuArrivee) {
        this.lieuArrivee = lieuArrivee;
    }

    public Instant getDateDepart() {
        return this.dateDepart;
    }

    public Trajet dateDepart(Instant dateDepart) {
        this.setDateDepart(dateDepart);
        return this;
    }

    public void setDateDepart(Instant dateDepart) {
        this.dateDepart = dateDepart;
    }

    public Instant getHeureDepart() {
        return this.heureDepart;
    }

    public Trajet heureDepart(Instant heureDepart) {
        this.setHeureDepart(heureDepart);
        return this;
    }

    public void setHeureDepart(Instant heureDepart) {
        this.heureDepart = heureDepart;
    }

    public Integer getPlaceDisp() {
        return this.placeDisp;
    }

    public Trajet placeDisp(Integer placeDisp) {
        this.setPlaceDisp(placeDisp);
        return this;
    }

    public void setPlaceDisp(Integer placeDisp) {
        this.placeDisp = placeDisp;
    }

    public String getCheminPhotoVoiture() {
        return this.cheminPhotoVoiture;
    }

    public Trajet cheminPhotoVoiture(String cheminPhotoVoiture) {
        this.setCheminPhotoVoiture(cheminPhotoVoiture);
        return this;
    }

    public void setCheminPhotoVoiture(String cheminPhotoVoiture) {
        this.cheminPhotoVoiture = cheminPhotoVoiture;
    }

    public String getConducteur() {
        return this.conducteur;
    }

    public Trajet conducteur(String conducteur) {
        this.setConducteur(conducteur);
        return this;
    }

    public void setConducteur(String conducteur) {
        this.conducteur = conducteur;
    }

    public String getListePassager() {
        return this.listePassager;
    }

    public Trajet listePassager(String listePassager) {
        this.setListePassager(listePassager);
        return this;
    }

    public void setListePassager(String listePassager) {
        this.listePassager = listePassager;
    }

    public ApplicationUser getApplicationUser() {
        return this.applicationUser;
    }

    public void setApplicationUser(ApplicationUser applicationUser) {
        this.applicationUser = applicationUser;
        this.applicationUserId = applicationUser != null ? applicationUser.getId() : null;
    }

    public Trajet applicationUser(ApplicationUser applicationUser) {
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

    public Trajet utilisateur(Utilisateur utilisateur) {
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
        if (!(o instanceof Trajet)) {
            return false;
        }
        return getId() != null && getId().equals(((Trajet) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Trajet{" +
            "id=" + getId() +
            ", lieuDepart='" + getLieuDepart() + "'" +
            ", lieuArrivee='" + getLieuArrivee() + "'" +
            ", dateDepart='" + getDateDepart() + "'" +
            ", heureDepart='" + getHeureDepart() + "'" +
            ", placeDisp=" + getPlaceDisp() +
            ", cheminPhotoVoiture='" + getCheminPhotoVoiture() + "'" +
            ", conducteur='" + getConducteur() + "'" +
            ", listePassager='" + getListePassager() + "'" +
            "}";
    }
}
