package tpspring.tpbanque.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tpspring.tpbanque.REPOSITORIES.CompteRepository;
import tpspring.tpbanque.entities.Compte;

import java.util.List;

@RestController
@RequestMapping("/banque")
public class CompteRestController {

    @Autowired
    private CompteRepository compteRepository;

    @GetMapping("/comptes")
    public List<Compte> getComptes() {
        return compteRepository.findAll();
    }

    @GetMapping("/comptes/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteRepository.findById(id).orElse(null);
    }

    @PostMapping("/comptes")
    public Compte addCompte(@RequestBody Compte compte) {
        return compteRepository.save(compte);
    }

    @PutMapping("/comptes/{id}")
    public Compte updateCompte(@PathVariable Long id, @RequestBody Compte compte) {
        return compteRepository.findById(id).map(existingCompte -> {
            existingCompte.setSolde(compte.getSolde());
            existingCompte.setDateCreation(compte.getDateCreation());
            existingCompte.setType(compte.getType());
            return compteRepository.save(existingCompte);
        }).orElse(null);
    }

    @DeleteMapping("/comptes/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepository.deleteById(id);
    }
}
