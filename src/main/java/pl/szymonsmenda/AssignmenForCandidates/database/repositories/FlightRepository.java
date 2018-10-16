package pl.szymonsmenda.AssignmenForCandidates.database.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.AssignmenForCandidates.database.FlightEntity;
import pl.szymonsmenda.AssignmenForCandidates.database.TouristEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends CrudRepository<FlightEntity, Integer>{

    List<FlightEntity> findAll();
    List<FlightEntity> findByTourists(TouristEntity touristEntity);

    Optional<FlightEntity> findById(Integer id);

}
