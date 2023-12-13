package tn.microservice.ms_project.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.microservice.ms_project.entities.Produit;
import tn.microservice.ms_project.repositories.ProduitRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProduitService implements IProduitService{
    ProduitRepository produitRepository;
    @Override
    public Produit ajoutProduit(Produit prod) {
        return produitRepository.save(prod);
    }

    @Override
    public Produit MiseajourProduit(Produit prod) {
        return produitRepository.save(prod);
    }

    @Override
    public void supprimerProduit(long idPord) {
        produitRepository.deleteById(idPord);
    }

    @Override
    public List<Produit> trouverProduits() {
        List<Produit> produits = produitRepository.findAll();
        return produits;
    }
}
