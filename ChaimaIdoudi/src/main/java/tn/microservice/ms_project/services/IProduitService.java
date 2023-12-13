package tn.microservice.ms_project.services;

import tn.microservice.ms_project.entities.Produit;

import java.util.List;

public interface IProduitService {
    Produit ajoutProduit(Produit prod);
    Produit MiseajourProduit(Produit prod);

    void supprimerProduit(long idPord);

    List<Produit> trouverProduits();

}
