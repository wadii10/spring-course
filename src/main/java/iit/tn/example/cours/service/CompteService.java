package iit.tn.example.cours.service;

import iit.tn.example.cours.entity.Compte;
import iit.tn.example.cours.exception.CompteNotFoundException;
import iit.tn.example.cours.repository.CompteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompteService {
    
    private final CompteRepository compteRepository;

    public List<Compte> findAll() {
        return compteRepository.findAll();
    }

    public void deleteCompte(int rib) {
        compteRepository.deleteById(rib);
    }

    public void addCompte(Compte Compte) {
        compteRepository.save(Compte);
    }

    public Compte findById(Integer rib) throws CompteNotFoundException {
        return compteRepository.findById(rib).orElseThrow(() -> new CompteNotFoundException("Compte with Rib=" + rib + " is not found"));
    }

    public void updateCompte(Compte compte) {
        Compte existingCompte = compteRepository.findById(compte.getRib())
                .orElseThrow(() -> new CompteNotFoundException("Compte with RIB=" + compte.getRib() + " not found"));
        existingCompte.setNomClient(compte.getNomClient());
        existingCompte.setSolde(compte.getSolde());
        compteRepository.save(existingCompte);
    }

}
