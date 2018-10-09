package pl.szymonsmenda.AssignmenForCandidates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szymonsmenda.AssignmenForCandidates.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.models.forms.TouristForm;
import pl.szymonsmenda.AssignmenForCandidates.models.services.TouristService;

import java.util.Optional;

@Controller
public class TouristController{

    final TouristService touristService;

    @Autowired
    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }


    @GetMapping("/addTourist")
    public String addTourist(Model model) {
        model.addAttribute("touristForm", new TouristForm());
        return "addTourist";
    }

    @PostMapping("/addTourist")
    public String addTourist(@ModelAttribute("touristForm") TouristForm touristForm,
                             RedirectAttributes redirectAttributes) {
        touristService.addTourist(touristForm);
        redirectAttributes.addFlashAttribute("touristAdd", " Turysta został dodany");
        return "redirect:/allTourist";
    }

    @GetMapping("/allTourist")
    public String allTourist(Model model) {
        model.addAttribute("tourists", touristService.getAll());
        return "allTourist";
    }

    @GetMapping("/allTourist/{touristId}")
    public String allContacts(@PathVariable("touristId") int touristId,
                              Model model) {
        model.addAttribute("touristDetails", touristService.getAllDetails(touristId));
        return "showTouristDetails";
    }

    @GetMapping("/deleteTourist/{touristId}")
    public String deleteTourist(@PathVariable("touristId") int touristId,
                                RedirectAttributes redirectAttributes) {
        touristService.deleteTourist(touristId);
        redirectAttributes.addFlashAttribute("touristDeleted", " Turysta został usunięty");
        return "redirect:/allTourist";
    }
}




//todo: edycja turysty(danych)
//    @GetMapping("/editTourist/{touristId}")
//    public String editPost(@PathVariable("touristId") int touristId,
//                           Model model,
//                           RedirectAttributes redirectAttributes) {
//        Optional<TouristEntity> postEntityOptional = touristService.getTouristById(touristId);
//        if (postEntityOptional.isPresent()) {
//            touristService.updateTourist(postEntityOptional);
//            model.addAttribute("touristForm", postEntityOptional);
//            return "edit_tourist";
//        }
//        return "redirect:/allTourist/" + touristId;
//    }
//    @PostMapping("/editTourist/{touristId}")
//    public String post(@PathVariable("touristId") int touristId,
//                       @ModelAttribute("touristForm") TouristForm touristForm,
//                       RedirectAttributes redirectAttributes) {
//        touristService.addTourist(touristForm);
////        redirectAttributes.addFlashAttribute("postUpdated", "Post został zmieniony");
//        return "allTourist";




