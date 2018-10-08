package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TouristForm{

    private String firstname;
    private String lastname;
    private String country;
    private String remarks;

    private String gender;
//    private LocalDate dateBirth;



    public TouristForm() {
    }


}
