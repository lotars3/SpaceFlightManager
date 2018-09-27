package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import lombok.Data;
import java.util.Date;

@Data
public class TouristForm{

    private String firstname;
    private String lastname;
    private String country;
    private String remarks;
    private Date birthday;
//    private String Listofflights; //TODO:  List of flights, Hash?


    public TouristForm() {
    }

}
