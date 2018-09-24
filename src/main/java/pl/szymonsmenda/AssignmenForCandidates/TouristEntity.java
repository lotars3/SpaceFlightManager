package pl.szymonsmenda.AssignmenForCandidates;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tourist")
@Data
public class TouristEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JoinColumn(name = "firstname")
    private String firstname;
    @JoinColumn(name = "lastname")
    private String lastname;
    @JoinColumn(name = "country")
    private String country;
    @JoinColumn(name = "remarks")
    private String remarks;
    // private String dateOfBirth;
    //private String Listofflights; //TODO:  List of flights, Hash?

}
