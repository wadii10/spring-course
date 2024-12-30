package iit.tn.example.cours.contrroller;

import iit.tn.example.cours.entity.Compte;
import iit.tn.example.cours.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comptes")
@AllArgsConstructor
public class CompteController {

    private final CompteService compteService;

    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("comptes", compteService.findAll());
        return "comptes";
    }

    @PostMapping("/add-compte")
    public String addStudent(@ModelAttribute Compte compte) {
        compteService.addCompte(compte);
        return "redirect:/comptes/index";
    }

    @PostMapping("/delete-compte")
    public String deleteCompte(@RequestParam("rib") Integer rib) {
        compteService.deleteCompte(rib);
        return "redirect:/comptes/index";
    }

    @ResponseBody
    @PostMapping("/delete-compte-ajax")
    public void deleteCompteAjax(@RequestParam int rib) {
        compteService.deleteCompte(rib);
    }

    @ResponseBody
    @GetMapping("/get-compte")
    public Compte getCompte(@RequestParam Integer rib) {
        return compteService.findById(rib);
    }

    @ResponseBody
    @PutMapping("/update-compte")
    public void updateCompte(@RequestBody Compte compte) {
        compteService.updateCompte(compte);
    }
}
