package com.esprit.microservices.commande.entities;

import com.esprit.microservices.commande.Enum.StatutCommande;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table( name = "Commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCommande")
    private int idCommande;
    private String adresseLivraison;
    private LocalDateTime dateCommande;

    private Double montant;

    private int idUser;

    private int quantite;

    @ElementCollection
    private List<String> produits ;

    private StatutCommande statut;

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getAdresseLivraison() {
        return adresseLivraison;
    }

    public void setAdresseLivraison(String adresseLivraison) {
        this.adresseLivraison = adresseLivraison;
    }

    public LocalDateTime getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(LocalDateTime dateCommande) {
        this.dateCommande = dateCommande;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public List<String> getProduits() {
        return produits;
    }

    public void setProduits(List<String> produits) {
        this.produits = produits;
    }

    public StatutCommande getStatut() {
        return statut;
    }

    public void setStatut(StatutCommande statut) {
        this.statut = statut;
    }

    public Commande() {
        super();
    }


    public Commande(String adresseLivraison, LocalDateTime dateCommande, Double montant, int quantite, List<String> produits, StatutCommande statut) {
        this.adresseLivraison = adresseLivraison;
        this.dateCommande = dateCommande;
        this.montant = montant;
        this.quantite = quantite;
        this.produits = produits;
        this.statut = statut;
    }
}
