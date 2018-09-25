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
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "country")
    private String country;
    @Column(name = "remarks")
    private String remarks;
    // private String dateOfBirth;
    //private String Listofflights; //TODO:  List of flights, Hash?

}
