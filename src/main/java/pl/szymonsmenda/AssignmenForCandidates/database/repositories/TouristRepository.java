package pl.szymonsmenda.AssignmenForCandidates.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.database.TouristEntity;

import java.util.List;

@Repository
public interface TouristRepository extends CrudRepository<TouristEntity, Integer>{


    List<TouristEntity> findAll();

    List<TouristEntity> findByFlights(FlightEntity flightEntity);
}
