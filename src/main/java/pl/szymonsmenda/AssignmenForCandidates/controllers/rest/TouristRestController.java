package pl.szymonsmenda.AssignmenForCandidates.controllers.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.szymonsmenda.AssignmenForCandidates.database.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.services.TouristService;

import java.util.List;

@RestController
@RequestMapping("rest")
public class TouristRestController{

    final TouristService touristService;

    public TouristRestController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping(value = "/tourists" , produces = "application/json")
    public ResponseEntity<List<TouristEntity>> listOfTourist(){
        return ResponseEntity.ok(touristService.getListOfTourists());
    }

    @PostMapping(value = "/tourists", consumes = "application/json")
    public ResponseEntity addTourist(@RequestBody TouristEntity touristEntity){
        touristService.saveTourist(touristEntity);
        return ResponseEntity.ok(touristEntity);
    }
    @DeleteMapping(value = "/tourists/{touristId}", produces = "application/json")
    public ResponseEntity deleteTourist(@PathVariable("touristId") int touristId){
        touristService.deleteTourist(touristId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/tourists/{touristId}/flights/{flightId}", consumes = "application/json")
    public ResponseEntity saveTouristToFlight(@PathVariable("flightId") int flightId, @PathVariable("touristId") int touristId) {
        touristService.saveTouristToFlight(flightId, touristId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/tourists/{touristId}/flights/{flightId}" ,produces ="application/json" )
    public ResponseEntity removeTouristFromFlight(@PathVariable("flightId") int flightId, @PathVariable("touristId") int touristId){
        touristService.removeTouristFromFlight(flightId, touristId);
        return ResponseEntity.ok().build();
    }
}
