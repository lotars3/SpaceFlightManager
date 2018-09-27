package pl.szymonsmenda.AssignmenForCandidates;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    @Column(name = "dateOfBirth")
    private Date birthday;
    //private String Listofflights; //TODO:  List of flights, Hash?

}
