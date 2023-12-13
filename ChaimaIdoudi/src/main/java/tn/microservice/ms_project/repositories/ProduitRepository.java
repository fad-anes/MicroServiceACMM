package tn.microservice.ms_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.microservice.ms_project.entities.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
