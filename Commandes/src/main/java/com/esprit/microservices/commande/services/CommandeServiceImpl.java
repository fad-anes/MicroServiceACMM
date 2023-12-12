package com.esprit.microservices.commande.services;

import com.esprit.microservices.commande.Enum.StatutCommande;
import com.esprit.microservices.commande.entities.Commande;
import com.esprit.microservices.commande.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements ICommandeService {

    @Autowired
    CommandeRepository commandeRepository;


    @Override
    public List<Commande> retrieveAllCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(Commande c) {
        return commandeRepository.save(c);
    }

    @Override
    public Commande updateCommande(Commande c, int idCommande) {
        return commandeRepository.save(c);
    }

    @Override
    public Commande retrieveCommande(int idCommande) {
        return commandeRepository.findById(idCommande).get();
    }

    @Override
    public void removeCommande(int idCommande) {
        commandeRepository.deleteById(idCommande);
    }

    public Commande annulerCommande(int idCommande) {
        Optional<Commande> optionalCommande = commandeRepository.findById(idCommande);
        if (optionalCommande.isPresent()) {
            Commande commande = optionalCommande.get();
            commande.setStatut(StatutCommande.ANNULEE);
            return commandeRepository.save(commande);
        }
        return null; // Indicates commande not found
    }


}

