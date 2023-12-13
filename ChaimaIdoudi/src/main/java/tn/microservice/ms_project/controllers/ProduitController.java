package tn.microservice.ms_project.controllers;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.microservice.ms_project.entities.Produit;
import tn.microservice.ms_project.services.IProduitService;

import java.util.List;
/*****************For Angular Communation***************/
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@AllArgsConstructor
@RequestMapping("/produit")
public class ProduitController {
    IProduitService produitService;

    @PostMapping("/ajoutProduit")
    public Produit ajoutProduit(@RequestBody Produit prod){
        Produit produit = produitService.ajoutProduit(prod);
        return produit;
    }

    @PutMapping("/MiseajourProduit")
    public Produit MiseajourProduit(@RequestBody Produit prod){
        Produit produit = produitService.MiseajourProduit(prod);
        return produit;
    }

    @DeleteMapping("/supprimerProduit/{id-produit}")
    void supprimerProduit(@PathVariable("id-produit")long id){
        produitService.supprimerProduit(id);
    }

    @GetMapping("/trouverProduits")
    public List<Produit> trouverProduits(){
        List<Produit> produits = produitService.trouverProduits();
        return produits;
    }
}
