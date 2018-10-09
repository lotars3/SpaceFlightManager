package pl.szymonsmenda.AssignmenForCandidates.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.models.forms.FlightForm;
import pl.szymonsmenda.AssignmenForCandidates.models.repositories.FlightRepository;

import java.time.LocalDate;
import java.util.List;

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
}
