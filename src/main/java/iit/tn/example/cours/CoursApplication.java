package iit.tn.example.cours;

import iit.tn.example.cours.beans.Wadii;
import iit.tn.example.cours.entity.Compte;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class CoursApplication implements CommandLineRunner {

	@PersistenceContext
	private EntityManager entityManager; // JPA

	public static void main(String[] args) {
		SpringApplication.run(CoursApplication.class, args);
	}

	@Transactional // --> commit
	@Override
	public void run(String... args) throws Exception {
		//recherche par d'autre critère (à part le PK)
		// JP-QL != SQL, --> ~= SQL orienté Objet (nom de l'entity + nom des attributs)
		// :nc --> nc est une variable
		List<Compte> comptes = entityManager.createQuery("select c from Compte c where c.nomClient = :nc", Compte.class)
				.setParameter("nc", "walha") // remplacer la variable nc par la valeur "walha" + filtrage d'injection SQL
				.getResultList();

		System.out.println(comptes);
		// SQL natif
		List<Compte> comptes2 = entityManager.createNativeQuery("select * from t_compte c where c.client = :nc", Compte.class)
				.setParameter("nc", "walha") // remplacer la variable nc par la valeur "walha" + filtrage d'injection SQL
				.getResultList();

		System.out.println(comptes2);

		//remove
	/*	Compte cp5 = entityManager.find(Compte.class, 3);
		entityManager.remove(cp5);*/


		//update
	/*	Compte cp5 = entityManager.find(Compte.class, 3);
		cp5.setSolde(50+cp5.getSolde());
		entityManager.merge(cp5);*/

		//recherche: par PK
	/*	Compte cp4 = entityManager.find(Compte.class, 2);
		System.out.println(cp4);*/

		// Ajout --> persist
	/*Compte cp1 = new Compte("Wadi3", 100);
	entityManager.persist(cp1);
	Compte cp2 = new Compte("Walha", 250);
	entityManager.persist(cp2);
	Compte cp3 = new Compte("Salma", 500);
	entityManager.persist(cp3);*/

	}
}
