package pl.szymonsmenda.AssignmenForCandidates.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.models.forms.TouristForm;
import pl.szymonsmenda.AssignmenForCandidates.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.models.repositories.TouristRepository;

@Service
public class TouristService{

    final TouristRepository touristRepository;
    @Autowired
    public TouristService(TouristRepository touristRepository) {
        this.touristRepository = touristRepository;
    }

    public void addTourist(TouristForm touristForm){
        TouristEntity touristEntity = createEntityFromForm(touristForm);

        touristRepository.save(touristEntity);
    }

    private TouristEntity createEntityFromForm(TouristForm touristForm) {
        TouristEntity touristEntity = new TouristEntity();
        touristEntity.setFirstname(touristForm.getFirstname());
        touristEntity.setLastname(touristForm.getLastname());
        touristEntity.setCountry(touristForm.getCountry());
        touristEntity.setRemarks(touristForm.getRemarks());
        return touristEntity;
    }
}
