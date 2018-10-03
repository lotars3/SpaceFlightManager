package pl.szymonsmenda.AssignmenForCandidates.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.AssignmenForCandidates.FlightEntity;

import java.util.List;

@Repository
public interface FlightRepository extends CrudRepository<FlightEntity, Integer>{

    List<FlightEntity> findAll();
}
