package com.esprit.microservices.commande.controller;

import com.esprit.microservices.commande.entities.Commande;
import com.esprit.microservices.commande.services.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/commande")
public class CommandeController {

    @Autowired
    ICommandeService commandeService;



    @GetMapping("/retrieve-all-commandes")
    public List<Commande> retrieveAllCommandes() {
        List<Commande> listCommandes = commandeService.retrieveAllCommandes();
        return listCommandes;
    }

    @PostMapping("/add-commande")
    public Commande addCommande(@RequestBody Commande c) {
        // This is where the NullPointerException occurs (example)
        Commande commande = commandeService.addCommande(c); // commandeService is null here
        return commande;
    }


    @PutMapping("/update-commande/{idCommande}")
    public Commande updateCommande(@RequestBody Commande c, @PathVariable("idCommande") int idCommande) {
        Commande commande = commandeService.updateCommande(c,idCommande);
        return commande;
    }


    @GetMapping("/retrieve-commande/{idCommande}")
    public Commande retrieveCommande(@PathVariable("idCommande") int idCommande) {
        return commandeService.retrieveCommande(idCommande);
    }


    @DeleteMapping("/remove-commande/{idCommande}")
    public void removeCommande(@PathVariable("idCommande") int idCommande) {
        commandeService.removeCommande(idCommande);
    }

    @PutMapping("/annuler-commande/{id}")
    public ResponseEntity<?> annulerCommande(@PathVariable int id) {
        Commande commande = commandeService.annulerCommande(id);
        if (commande == null) {
            return new ResponseEntity<>("Commande not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(commande, HttpStatus.OK);
    }
}

