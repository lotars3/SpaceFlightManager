package pl.szymonsmenda.AssignmenForCandidates;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

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

//    @Column(name = "dateOfBirth")
//    private LocalDate birthday;
    //private String Listofflights; //TODO:  List of flights, Hash?

}
