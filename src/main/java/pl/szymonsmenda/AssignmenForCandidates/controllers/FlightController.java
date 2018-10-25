package pl.szymonsmenda.AssignmenForCandidates.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.forms.FlightForm;
import pl.szymonsmenda.AssignmenForCandidates.services.FlightService;

import java.util.Optional;


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
        model.addAttribute("flights", flightService.getListOfFlights());
        return "allFlight";
    }

    @GetMapping("/allFlight/{flightId}")
    public String allFlight(@PathVariable("flightId") int flightId,
                            Model model) {
        model.addAttribute("flightDetails", flightService.getAllFlightDetails(flightId));
        model.addAttribute("flightTouristDetails", flightService.getTouristForFlight(flightId));
        return "showFlightDetails";
    }

    @GetMapping("/deleteFlight/{flightId}")
    public String deleteFlight(@PathVariable("flightId") int flightId,
                               RedirectAttributes redirectAttributes) {
        flightService.deleteFlight(flightId);
        redirectAttributes.addFlashAttribute("flightDeleted", " Lot został usunięty");
        return "redirect:/allFlight";
    }

    @GetMapping("/editFlight/{flightId}")
    public String editFlight(@PathVariable("flightId") int flightId,
                             Model model) {
        Optional<FlightEntity> FlightEntityOptional = flightService.getFlightById(flightId);
        if (FlightEntityOptional.isPresent()) {
            flightService.updateFlight(FlightEntityOptional);
            model.addAttribute("flightForm", FlightEntityOptional);
            return "editFlight";
        }
        return "redirect:/allFlight/" + flightId;
    }

    @PostMapping("/editFlight/{flightId}")
    public String editFlight(@PathVariable("flightId") int flightId,
                             @ModelAttribute("flightForm") FlightForm flightForm,
                             RedirectAttributes redirectAttributes) {

        flightService.saveupdateFlight(flightForm, flightId);
        redirectAttributes.addFlashAttribute("flightUpdate", "Dane lotu zostały poprawione");
        return "redirect:/allFlight/" + flightId;


    }


}
