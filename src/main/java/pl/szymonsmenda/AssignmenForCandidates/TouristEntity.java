package pl.szymonsmenda.AssignmenForCandidates;

import lombok.Data;


import javax.persistence.*;
import java.time.LocalDate;

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


    private String gender;
//    @Column(name = "dateBirth")
//    private LocalDate dateBirth;






}
