package iit.tn.example.cours.repository;

import iit.tn.example.cours.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte, Integer> {

}
