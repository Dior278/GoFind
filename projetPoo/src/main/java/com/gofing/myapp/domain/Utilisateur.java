package com.gofing.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A Utilisateur.
 */
@Table("utilisateur")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Utilisateur implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("nom")
    private String nom;

    @Column("prenom")
    private String prenom;

    @Column("email")
    private String email;

    @Column("numero_tel")
    private String numeroTel;

    @Column("mot_de_passe")
    private String motDePasse;

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

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Utilisateur id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return this.nom;
    }

    public Utilisateur nom(String nom) {
        this.setNom(nom);
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public Utilisateur prenom(String prenom) {
        this.setPrenom(prenom);
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return this.email;
    }

    public Utilisateur email(String email) {
        this.setEmail(email);
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumeroTel() {
        return this.numeroTel;
    }

    public Utilisateur numeroTel(String numeroTel) {
        this.setNumeroTel(numeroTel);
        return this;
    }

    public void setNumeroTel(String numeroTel) {
        this.numeroTel = numeroTel;
    }

    public String getMotDePasse() {
        return this.motDePasse;
    }

    public Utilisateur motDePasse(String motDePasse) {
        this.setMotDePasse(motDePasse);
        return this;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Set<Trajet> getTrajets() {
        return this.trajets;
    }

    public void setTrajets(Set<Trajet> trajets) {
        if (this.trajets != null) {
            this.trajets.forEach(i -> i.setUtilisateur(null));
        }
        if (trajets != null) {
            trajets.forEach(i -> i.setUtilisateur(this));
        }
        this.trajets = trajets;
    }

    public Utilisateur trajets(Set<Trajet> trajets) {
        this.setTrajets(trajets);
        return this;
    }

    public Utilisateur addTrajet(Trajet trajet) {
        this.trajets.add(trajet);
        trajet.setUtilisateur(this);
        return this;
    }

    public Utilisateur removeTrajet(Trajet trajet) {
        this.trajets.remove(trajet);
        trajet.setUtilisateur(null);
        return this;
    }

    public Set<ObjetVole> getObjetVoles() {
        return this.objetVoles;
    }

    public void setObjetVoles(Set<ObjetVole> objetVoles) {
        if (this.objetVoles != null) {
            this.objetVoles.forEach(i -> i.setUtilisateur(null));
        }
        if (objetVoles != null) {
            objetVoles.forEach(i -> i.setUtilisateur(this));
        }
        this.objetVoles = objetVoles;
    }

    public Utilisateur objetVoles(Set<ObjetVole> objetVoles) {
        this.setObjetVoles(objetVoles);
        return this;
    }

    public Utilisateur addObjetVole(ObjetVole objetVole) {
        this.objetVoles.add(objetVole);
        objetVole.setUtilisateur(this);
        return this;
    }

    public Utilisateur removeObjetVole(ObjetVole objetVole) {
        this.objetVoles.remove(objetVole);
        objetVole.setUtilisateur(null);
        return this;
    }

    public Set<Maison> getMaisons() {
        return this.maisons;
    }

    public void setMaisons(Set<Maison> maisons) {
        if (this.maisons != null) {
            this.maisons.forEach(i -> i.setUtilisateur(null));
        }
        if (maisons != null) {
            maisons.forEach(i -> i.setUtilisateur(this));
        }
        this.maisons = maisons;
    }

    public Utilisateur maisons(Set<Maison> maisons) {
        this.setMaisons(maisons);
        return this;
    }

    public Utilisateur addMaison(Maison maison) {
        this.maisons.add(maison);
        maison.setUtilisateur(this);
        return this;
    }

    public Utilisateur removeMaison(Maison maison) {
        this.maisons.remove(maison);
        maison.setUtilisateur(null);
        return this;
    }

    public Set<PieceALouer> getPieceALouers() {
        return this.pieceALouers;
    }

    public void setPieceALouers(Set<PieceALouer> pieceALouers) {
        if (this.pieceALouers != null) {
            this.pieceALouers.forEach(i -> i.setUtilisateur(null));
        }
        if (pieceALouers != null) {
            pieceALouers.forEach(i -> i.setUtilisateur(this));
        }
        this.pieceALouers = pieceALouers;
    }

    public Utilisateur pieceALouers(Set<PieceALouer> pieceALouers) {
        this.setPieceALouers(pieceALouers);
        return this;
    }

    public Utilisateur addPieceALouer(PieceALouer pieceALouer) {
        this.pieceALouers.add(pieceALouer);
        pieceALouer.setUtilisateur(this);
        return this;
    }

    public Utilisateur removePieceALouer(PieceALouer pieceALouer) {
        this.pieceALouers.remove(pieceALouer);
        pieceALouer.setUtilisateur(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Utilisateur)) {
            return false;
        }
        return getId() != null && getId().equals(((Utilisateur) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Utilisateur{" +
            "id=" + getId() +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", email='" + getEmail() + "'" +
            ", numeroTel='" + getNumeroTel() + "'" +
            ", motDePasse='" + getMotDePasse() + "'" +
            "}";
    }
}
