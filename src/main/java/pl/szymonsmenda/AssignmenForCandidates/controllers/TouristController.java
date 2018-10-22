package pl.szymonsmenda.AssignmenForCandidates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szymonsmenda.AssignmenForCandidates.database.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.forms.TouristForm;
import pl.szymonsmenda.AssignmenForCandidates.services.TouristService;

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
    public String addTourist(@ModelAttribute("touristForm") TouristEntity touristEntity,
                             RedirectAttributes redirectAttributes) {
        touristService.saveTourist(touristEntity);
        redirectAttributes.addFlashAttribute("touristAdd", " Turysta został dodany");
        return "redirect:/allTourist";
    }

    @GetMapping("/allTourist")
    public String allTourist(Model model) {
        model.addAttribute("tourists", touristService.getListOfTourists());
        return "allTourist";
    }

    @GetMapping("/allTourist/{touristId}")
    public String allContacts(@PathVariable("touristId") int touristId,
                              Model model) {
        model.addAttribute("touristDetails", touristService.getAllDetails(touristId));
        model.addAttribute("flightDetails", touristService.getFlightsForTourist(touristId));
        return "showTouristDetails";
    }

    @GetMapping("/deleteTourist/{touristId}")
    public String deleteTourist(@PathVariable("touristId") int touristId,
                                RedirectAttributes redirectAttributes) {
        touristService.deleteTourist(touristId);
        redirectAttributes.addFlashAttribute("touristDeleted", " Turysta został usunięty");
        return "redirect:/allTourist";
    }

    @GetMapping("/editTourist/{touristId}")
    public String editTourist(@PathVariable("touristId") int touristId,
                              Model model) {
        Optional<TouristEntity> EntityOptional = touristService.getTouristById(touristId);
        if (EntityOptional.isPresent()) {
            touristService.updateTourist(EntityOptional);
            model.addAttribute("touristForm", EntityOptional);
            return "editTourist";
        }
        return "redirect:/allTourist/" + touristId;
    }

    @PostMapping("/editTourist/{touristId}")
    public String editTourist(@PathVariable("touristId") int touristId,
                              @ModelAttribute("touristForm") TouristForm touristForm,
                              RedirectAttributes redirectAttributes) {

        touristService.saveUpdateTourist(touristForm, touristId);
        redirectAttributes.addFlashAttribute("touristUpdate", "Dane turysty zostały poprawione");
        return "redirect:/allTourist/" + touristId;
    }

    @GetMapping("/tourists/{id}/flights")
    public String getFlightsForTourist(@PathVariable int touristId) {
        touristService.getFlightsForTourist(touristId);
        return "showTouristDetails";
    }

    @PostMapping("/tourists/{touristId}/flights/{flightId}")
    public String addFlightToTourist(@PathVariable("touristId") int touristId,
                                     @PathVariable("flightId") int flightId,
                                     RedirectAttributes redirectAttributes) {
        touristService.addFlightToTourist(touristId, flightId);
        redirectAttributes.addFlashAttribute("touristAdd", " Lot został przypisany do turysty");

        return "showTouristDetails";

    }
}




