package pl.szymonsmenda.AssignmenForCandidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.database.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.database.repositories.FlightRepository;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.database.repositories.TouristRepository;
import pl.szymonsmenda.AssignmenForCandidates.forms.FlightForm;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService{
    final FlightRepository flightRepository;
    final TouristRepository touristRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository, TouristRepository touristRepository) {
        this.flightRepository = flightRepository;
        this.touristRepository = touristRepository;
    }

    public void addFlight(FlightEntity flightEntity) {
        flightRepository.save(flightEntity);
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

    public List<FlightEntity> getListOfFlights() {
        return flightRepository.findAll();
    }


    public FlightEntity getAllFlightDetails(int flightId) {
        return flightRepository.findById(flightId).get();
    }

    public void deleteFlight(int flightId) {
        flightRepository.deleteById(flightId);
    }

    public FlightForm updateFlight(Optional<FlightEntity> FlightEntityOptional) {
        FlightForm flightForm = new FlightForm();
        flightForm.setFlightPrice(FlightEntityOptional.get().getFlightPrice());
        flightForm.setNumberSeats(FlightEntityOptional.get().getNumberSeats());
        flightForm.setDepartureTime(FlightEntityOptional.get().getDepartureTime());
        flightForm.setArrivalTime(FlightEntityOptional.get().getArrivalTime());

        return flightForm;
    }

    public void saveupdateFlight(FlightForm flightForm, int flightId) {
        FlightEntity flightEntity = createEntityFromFlightForm(flightForm);
        flightEntity.setId(flightId);
        flightRepository.save(flightEntity);
    }

    public Optional<FlightEntity> getFlightById(int flightId) {
        return flightRepository.findById(flightId);
    }

    public void saveFlightToTourist(int flightId, int touristId){
        FlightEntity flightEntity = findFlightEntity(flightId);
        TouristEntity touristEntity = findTouristEntity(touristId);

        flightEntity.getTourists().add(touristEntity);
        touristEntity.getFlights().add(flightEntity);

        touristRepository.save(touristEntity);
        flightRepository.save(flightEntity);
    }

    public void removeFlightFromTourist(int flightId, int touristId) {
        FlightEntity flightEntity = findFlightEntity(flightId);
        TouristEntity touristEntity = findTouristEntity(touristId);

        flightEntity.getTourists().remove(touristEntity);
        touristEntity.getFlights().remove(flightEntity);

        touristRepository.save(touristEntity);
        flightRepository.save(flightEntity);
    }

    public TouristEntity findTouristEntity(int touristId){
        return touristRepository.findById(touristId)
                .orElseThrow(() -> new RuntimeException("No tourists in database with id: " + touristId));
    }

    public FlightEntity findFlightEntity(int flightId){
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("No flights in database with id: " + flightId));
    }


}