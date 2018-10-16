package pl.szymonsmenda.AssignmenForCandidates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szymonsmenda.AssignmenForCandidates.forms.FlightForm;
import pl.szymonsmenda.AssignmenForCandidates.services.FlightService;


@Controller
public class FlightController{

    final FlightService flightService;

    @Autowired
    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/addFlight")
    public String addFlight(Model model) {
        model.addAttribute("flightForm", new FlightForm());
        return "addFlight";
    }

    @PostMapping("/addFlight")
    public String addFlight(@ModelAttribute("flightForm") FlightForm flightForm,
                            RedirectAttributes redirectAttributes) {
        flightService.addFlight(flightForm);
        redirectAttributes.addFlashAttribute("flightAdd", " Lot został dodany");
        return "redirect:/allFlight";
    }


    @GetMapping("/allFlight")
    public String allFlight(Model model) {
        model.addAttribute("flights", flightService.getAll());
        return "allFlight";
    }

    @GetMapping("/allFlight/{flightId}")
    public String allFlight(@PathVariable("flightId") int flightId,
                            Model model) {
        model.addAttribute("flightDetails", flightService.getAllDetails(flightId));
        return "showFlightDetails";
    }

    @GetMapping("/deleteFlight/{flightId}")
    public String deleteFlight(@PathVariable("flightId") int flightId,
                               RedirectAttributes redirectAttributes) {
        flightService.deleteFlight(flightId);
        redirectAttributes.addFlashAttribute("flightDeleted", " Lot został usunięty");
        return "redirect:/allFlight";
    }


}
