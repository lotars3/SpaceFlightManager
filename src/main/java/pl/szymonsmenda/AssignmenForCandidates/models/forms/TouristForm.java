package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import lombok.Data;

@Data
public class TouristForm{

    private String firstname;
    private String lastname;
    private String country;
    private String remarks;

//    private LocalDate birthday;
//    private String Listofflights; //TODO:  List of flights, Hash?


    public TouristForm() {
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
