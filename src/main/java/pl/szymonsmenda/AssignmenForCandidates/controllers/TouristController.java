package pl.szymonsmenda.AssignmenForCandidates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.szymonsmenda.AssignmenForCandidates.models.forms.TouristForm;
import pl.szymonsmenda.AssignmenForCandidates.models.services.TouristService;

@Controller
public class TouristController{

    final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/tourist")
    public String tourist(Model model) {
        model.addAttribute("touristForm", new TouristForm());
        return "addTourist";
    }

    @PostMapping("/tourist")
    public String tourist(@ModelAttribute("touristForm") TouristForm touristForm) {
        touristService.addTourist(touristForm);
        return "redirect:/";
    }

    @GetMapping ("/allTourist")
    public String allTourist(Model model){
        model.addAttribute("tourists", touristService.getAll() );
        return "allTourist";
    }

    @GetMapping("/allTourist/{id}")
    public String allContacts(@PathVariable("id") int id,
                              Model model){
        model.addAttribute("touristDetails", touristService.getAllDetails(id));
        return "showTouristDetails";


    }

}
