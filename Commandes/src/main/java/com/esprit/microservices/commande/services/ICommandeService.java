package com.esprit.microservices.commande.services;

import com.esprit.microservices.commande.entities.Commande;

import java.util.List;

public interface ICommandeService {

    List<Commande> retrieveAllCommandes();
    Commande addCommande(Commande c);
    Commande updateCommande(Commande c,int idCommande);
    Commande retrieveCommande(int idCommande);
    void removeCommande(int idCommande);

    Commande annulerCommande(int idCommmande);

}

