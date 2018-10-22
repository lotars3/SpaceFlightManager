package pl.szymonsmenda.AssignmenForCandidates.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.services.FlightService;

import java.util.List;

@RestController
@RequestMapping("rest")
public class FlightRestController{

    final FlightService flightService;

    @Autowired
    public FlightRestController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping(value = "/flight", produces = "application/json")
    public ResponseEntity<List<FlightEntity>> listOfFlights() {
        return ResponseEntity.ok(flightService.getListOfFlights());
    }

    @PostMapping(value = "/flight", consumes = "application/json")
    public ResponseEntity addFlight(@RequestBody FlightEntity flightEntity) {
        flightService.addFlight(flightEntity);
        return ResponseEntity.ok(flightEntity);
    }

    @DeleteMapping(value = "/flight/{flightId}", produces = "application/json")
    public ResponseEntity deleteFlight (@PathVariable("flightId") int flightId){
        flightService.deleteFlight(flightId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/flights/{flightId}/tourists/{touristId}", consumes = "application/json")
    public ResponseEntity saveFlightToTourist(@PathVariable("flightId") int flightId, @PathVariable("touristId") int touristId) {
        flightService.saveFlightToTourist(flightId, touristId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/flights/{flightId}/tourists/{touristId}" ,produces ="application/json" )
    public ResponseEntity removeFlightFromTourist(@PathVariable("flightId") int flightId, @PathVariable("touristId") int touristId){
        flightService.removeFlightFromTourist(flightId, touristId);
        return ResponseEntity.ok().build();
    }




}
