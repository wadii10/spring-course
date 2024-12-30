package iit.tn.example.cours.dao;

import iit.tn.example.cours.entity.Compte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CompteDao {
        @PersistenceContext
        private EntityManager entityManager;

        public void save(Compte compte) {
            entityManager.persist(compte);
        }

        public void update(Compte compte) {
            entityManager.merge(compte);
        }

        public void delete(Compte compte) {
            entityManager.remove(compte);
        }

        public Compte findById(Integer rib) {
            return entityManager.find(Compte.class, rib);
        }

        public List<Compte> findAll() {
            return entityManager.createQuery("select c from Compte c", Compte.class).getResultList();
        }

}

