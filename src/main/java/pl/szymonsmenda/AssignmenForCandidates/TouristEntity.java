package pl.szymonsmenda.AssignmenForCandidates;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


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

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;






}
