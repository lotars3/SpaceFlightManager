package pl.szymonsmenda.AssignmenForCandidates.models.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.szymonsmenda.AssignmenForCandidates.TouristEntity;

@Repository
public interface TouristRepository extends CrudRepository<TouristEntity, Integer>{


}
