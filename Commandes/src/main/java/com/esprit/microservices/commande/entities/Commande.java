package com.esprit.microservices.commande.entities;

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
    private Double montantTotal;

    private int idUser;

    private int quantite;

    @ElementCollection
    private List<String> produits ;

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

    public Double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(Double montantTotal) {
        this.montantTotal = montantTotal;
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

    public Commande() {
        super();
    }

    public Commande(String adresseLivraison, LocalDateTime dateCommande, int quantite, Double montantTotal) {
        this.adresseLivraison = adresseLivraison;
        this.dateCommande = dateCommande;
        this.quantite=quantite;
        this.montantTotal = montantTotal;

    }


    public Commande(int idCommande, String adresseLivraison, LocalDateTime dateCommande, int quantite, Double montantTotal) {
        this.idCommande = idCommande;
        this.adresseLivraison = adresseLivraison;
        this.dateCommande = dateCommande;
        this.quantite = quantite;
        this.montantTotal = montantTotal;

    }

    public Commande(int idCommande, String adresseLivraison, LocalDateTime dateCommande,int quantite, Double montantTotal, int idUser, List<String> produits) {
        this.idCommande = idCommande;
        this.adresseLivraison = adresseLivraison;
        this.dateCommande = dateCommande;
        this.quantite=quantite;
        this.montantTotal = montantTotal;
        this.idUser = idUser;
        this.produits = produits;
    }


    public Commande(String adresseLivraison, LocalDateTime dateCommande,int quantite, Double montantTotal, int idUser, List<String> produits) {
        this.adresseLivraison = adresseLivraison;
        this.dateCommande = dateCommande;
        this.quantite=quantite;
        this.montantTotal = montantTotal;
        this.idUser = idUser;
        this.produits = produits;
    }
}
