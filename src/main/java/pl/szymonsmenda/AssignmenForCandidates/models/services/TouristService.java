package pl.szymonsmenda.AssignmenForCandidates.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.szymonsmenda.AssignmenForCandidates.models.forms.TouristForm;
import pl.szymonsmenda.AssignmenForCandidates.TouristEntity;
import pl.szymonsmenda.AssignmenForCandidates.models.repositories.TouristRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        touristEntity.setDateBirth(LocalDate.parse(touristForm.getDateBirth().toString()));
        touristEntity.setGender(touristForm.getGender());
        return touristEntity;
    }

    public List<TouristEntity> getAll(){return touristRepository.findAll(); }

    public TouristEntity getAllDetails(int touristId) { return touristRepository.findById(touristId).get();}

    public void deleteTourist(int touristId){
        touristRepository.deleteById(touristId);
    }

    public TouristForm updateTourist (Optional<TouristEntity> entityOptional) {
        TouristForm touristForm = new TouristForm();
        touristForm.setFirstname(entityOptional.get().getFirstname());
        touristForm.setLastname(entityOptional.get().getLastname());
        touristForm.setCountry(entityOptional.get().getCountry());
        touristForm.setRemarks(entityOptional.get().getRemarks());
        touristForm.setGender(touristForm.getGender());

        return touristForm;
    }

    public Optional<TouristEntity> getTouristById(int touristId){
        return touristRepository.findById(touristId);
    }
}
