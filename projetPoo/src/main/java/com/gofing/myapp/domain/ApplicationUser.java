package com.gofing.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A ApplicationUser.
 */
@Table("application_user")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ApplicationUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Min(value = 42)
    @Max(value = 42)
    @Column("additional_field")
    private Integer additionalField;

    @Transient
    private User internalUser;

    @Transient
    @JsonIgnoreProperties(value = { "applicationUser", "utilisateur" }, allowSetters = true)
    private Set<Trajet> trajets = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "applicationUser", "utilisateur" }, allowSetters = true)
    private Set<ObjetVole> objetVoles = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "applicationUser", "utilisateur" }, allowSetters = true)
    private Set<Maison> maisons = new HashSet<>();

    @Transient
    @JsonIgnoreProperties(value = { "applicationUser", "utilisateur" }, allowSetters = true)
    private Set<PieceALouer> pieceALouers = new HashSet<>();

    @Column("internal_user_id")
    private Long internalUserId;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public ApplicationUser id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAdditionalField() {
        return this.additionalField;
    }

    public ApplicationUser additionalField(Integer additionalField) {
        this.setAdditionalField(additionalField);
        return this;
    }

    public void setAdditionalField(Integer additionalField) {
        this.additionalField = additionalField;
    }

    public User getInternalUser() {
        return this.internalUser;
    }

    public void setInternalUser(User user) {
        this.internalUser = user;
        this.internalUserId = user != null ? user.getId() : null;
    }

    public ApplicationUser internalUser(User user) {
        this.setInternalUser(user);
        return this;
    }

    public Set<Trajet> getTrajets() {
        return this.trajets;
    }

    public void setTrajets(Set<Trajet> trajets) {
        if (this.trajets != null) {
            this.trajets.forEach(i -> i.setApplicationUser(null));
        }
        if (trajets != null) {
            trajets.forEach(i -> i.setApplicationUser(this));
        }
        this.trajets = trajets;
    }

    public ApplicationUser trajets(Set<Trajet> trajets) {
        this.setTrajets(trajets);
        return this;
    }

    public ApplicationUser addTrajet(Trajet trajet) {
        this.trajets.add(trajet);
        trajet.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeTrajet(Trajet trajet) {
        this.trajets.remove(trajet);
        trajet.setApplicationUser(null);
        return this;
    }

    public Set<ObjetVole> getObjetVoles() {
        return this.objetVoles;
    }

    public void setObjetVoles(Set<ObjetVole> objetVoles) {
        if (this.objetVoles != null) {
            this.objetVoles.forEach(i -> i.setApplicationUser(null));
        }
        if (objetVoles != null) {
            objetVoles.forEach(i -> i.setApplicationUser(this));
        }
        this.objetVoles = objetVoles;
    }

    public ApplicationUser objetVoles(Set<ObjetVole> objetVoles) {
        this.setObjetVoles(objetVoles);
        return this;
    }

    public ApplicationUser addObjetVole(ObjetVole objetVole) {
        this.objetVoles.add(objetVole);
        objetVole.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeObjetVole(ObjetVole objetVole) {
        this.objetVoles.remove(objetVole);
        objetVole.setApplicationUser(null);
        return this;
    }

    public Set<Maison> getMaisons() {
        return this.maisons;
    }

    public void setMaisons(Set<Maison> maisons) {
        if (this.maisons != null) {
            this.maisons.forEach(i -> i.setApplicationUser(null));
        }
        if (maisons != null) {
            maisons.forEach(i -> i.setApplicationUser(this));
        }
        this.maisons = maisons;
    }

    public ApplicationUser maisons(Set<Maison> maisons) {
        this.setMaisons(maisons);
        return this;
    }

    public ApplicationUser addMaison(Maison maison) {
        this.maisons.add(maison);
        maison.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removeMaison(Maison maison) {
        this.maisons.remove(maison);
        maison.setApplicationUser(null);
        return this;
    }

    public Set<PieceALouer> getPieceALouers() {
        return this.pieceALouers;
    }

    public void setPieceALouers(Set<PieceALouer> pieceALouers) {
        if (this.pieceALouers != null) {
            this.pieceALouers.forEach(i -> i.setApplicationUser(null));
        }
        if (pieceALouers != null) {
            pieceALouers.forEach(i -> i.setApplicationUser(this));
        }
        this.pieceALouers = pieceALouers;
    }

    public ApplicationUser pieceALouers(Set<PieceALouer> pieceALouers) {
        this.setPieceALouers(pieceALouers);
        return this;
    }

    public ApplicationUser addPieceALouer(PieceALouer pieceALouer) {
        this.pieceALouers.add(pieceALouer);
        pieceALouer.setApplicationUser(this);
        return this;
    }

    public ApplicationUser removePieceALouer(PieceALouer pieceALouer) {
        this.pieceALouers.remove(pieceALouer);
        pieceALouer.setApplicationUser(null);
        return this;
    }

    public Long getInternalUserId() {
        return this.internalUserId;
    }

    public void setInternalUserId(Long user) {
        this.internalUserId = user;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUser)) {
            return false;
        }
        return getId() != null && getId().equals(((ApplicationUser) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUser{" +
            "id=" + getId() +
            ", additionalField=" + getAdditionalField() +
            "}";
    }
}
