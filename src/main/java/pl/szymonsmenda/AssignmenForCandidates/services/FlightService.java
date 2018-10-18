package pl.szymonsmenda.AssignmenForCandidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.database.repositories.FlightRepository;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.forms.FlightForm;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService{
    final FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public void addFlight(FlightForm flightForm) {
        FlightEntity flightEntity = createEntityFromFlightForm(flightForm);

        flightRepository.save(flightEntity);
    }

    private FlightEntity createEntityFromFlightForm(FlightForm flightForm) {
        FlightEntity flightEntity = new FlightEntity();
        flightEntity.setFlightPrice(flightForm.getFlightPrice());
        flightEntity.setNumberSeats(flightForm.getNumberSeats());
        flightEntity.setDepartureTime(flightForm.getDepartureTime());
        flightEntity.setArrivalTime(flightForm.getArrivalTime());
//        flightEntity.setDepartureTime(LocalDate.parse(flightForm.getDepartureTime().toString()));

        return flightEntity;
    }

    public List<FlightEntity> getAll() {
        return flightRepository.findAll();
    }

    public FlightEntity getAllDetails(int flightId) {
        return flightRepository.findById(flightId).get();
    }

    public void deleteFlight(int flightId) {
        flightRepository.deleteById(flightId);
    }

    public FlightForm updateFlight (Optional<FlightEntity> FlightEntityOptional) {
        FlightForm flightForm = new FlightForm();
        flightForm.setFlightPrice(FlightEntityOptional.get().getFlightPrice());
        flightForm.setNumberSeats(FlightEntityOptional.get().getNumberSeats());
        flightForm.setDepartureTime(FlightEntityOptional.get().getDepartureTime());
        flightForm.setArrivalTime(FlightEntityOptional.get().getArrivalTime());

        return flightForm;
    }

    public void saveupdateFlight(FlightForm flightForm ,int flightId ) {
        FlightEntity flightEntity = createEntityFromFlightForm(flightForm);
        flightEntity.setId(flightId);
        flightRepository.save(flightEntity);
    }

    public Optional<FlightEntity> getFlightById(int flightId){
        return flightRepository.findById(flightId);
    }
}