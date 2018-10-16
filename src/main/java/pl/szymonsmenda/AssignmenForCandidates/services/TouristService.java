package pl.szymonsmenda.AssignmenForCandidates.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.forms.TouristForm;
import pl.szymonsmenda.AssignmenForCandidates.database.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.database.repositories.FlightRepository;
import pl.szymonsmenda.AssignmenForCandidates.database.repositories.TouristRepository;

import java.util.List;

@Service
public class TouristService{

    final TouristRepository touristRepository;
    final FlightRepository flightRepository;

    @Autowired
    public TouristService(TouristRepository touristRepository, FlightRepository flightRepository) {
        this.touristRepository = touristRepository;
        this.flightRepository = flightRepository;
    }

    public void saveTourist(TouristEntity touristEntity){
        touristRepository.save(touristEntity);
    }


//    public void saveTourist(TouristForm touristForm) {
//        TouristEntity touristEntity = createEntityFromForm(touristForm);
//
//        touristRepository.save(touristEntity);
//    }
//
//    private TouristEntity createEntityFromForm(TouristForm touristForm) {
//        TouristEntity touristEntity = new TouristEntity();
//        touristEntity.setFirstname(touristForm.getFirstname());
//        touristEntity.setLastname(touristForm.getLastname());
//        touristEntity.setCountry(touristForm.getCountry());
//        touristEntity.setRemarks(touristForm.getRemarks());
//        touristEntity.setDateBirth(touristForm.getDateBirth());
//        touristEntity.setGender(touristForm.getGender());
//        return touristEntity;
//    }

    public List<TouristEntity> getListOfTourists() {
        return touristRepository.findAll();
    }

    public TouristEntity getAllDetails(int touristId) {
        return touristRepository.findById(touristId).get();
    }

    public void deleteTourist(int touristId) {
        touristRepository.deleteById(touristId);
    }

    public void addFlightToTourist(int touristId, int flightId) {

        FlightEntity flightEntity = findFlightEntity(flightId);
        TouristEntity touristEntity = findTouristEntity(touristId);

        flightEntity.getTourists().add(touristEntity);
        touristEntity.getFlights().add(flightEntity);

        touristRepository.save(touristEntity);
        flightRepository.save(flightEntity);

//        FlightEntity flightEntity = flightRepository.findById(Math.toIntExact(flightId))
//                .orElseThrow(() -> new RuntimeException("No flights in database with id: " + flightId));
//        TouristEntity touristEntity = touristRepository.findById(touristId.intValue())
//                .orElseThrow(() -> new RuntimeException("No tourists in database with id: " + touristId));
//        touristEntity.getFlights().add(flightEntity);
//
//        touristRepository.save(touristEntity);
    }

    public TouristEntity findTouristEntity(int touristId){
        return touristRepository.findById(touristId)
                .orElseThrow(() -> new RuntimeException("Brak turysty w bazie" + touristId));
    }

    public FlightEntity findFlightEntity(int flightId){
        return flightRepository.findById(flightId)
                .orElseThrow(() -> new RuntimeException("Brak lotu w bazie" + flightId));
    }

    public List<FlightEntity> getFlightsForTourist(int touristId) {
        TouristEntity touristEntity = touristRepository.findById(touristId)
                .orElseThrow(() -> new RuntimeException("No tourists in database with id: "));
        return flightRepository.findByTourists(touristEntity);
    }




    //todo: update turysty
//    public TouristForm updateTourist (Optional<TouristEntity> entityOptional) {
//        TouristForm touristForm = new TouristForm();
//        touristForm.setFirstname(entityOptional.get().getFirstname());
//        touristForm.setLastname(entityOptional.get().getLastname());
//        touristForm.setCountry(entityOptional.get().getCountry());
//        touristForm.setRemarks(entityOptional.get().getRemarks());
//        touristForm.setGender(touristForm.getGender());
//
//        return touristForm;
//    }

//    public Optional<TouristEntity> getTouristById(int touristId){
//        return touristRepository.findById(touristId);
//    }
}
