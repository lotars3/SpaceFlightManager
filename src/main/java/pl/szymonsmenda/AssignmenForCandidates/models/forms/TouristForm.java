package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import lombok.Data;

@Data
public class TouristForm{

    private String firstname;
    private String lastname;
    private String country;
    private String remarks;
    //private String dateOfBirth;
    //private String Listofflights; //TODO:  List of flights, Hash?
}
