package pl.szymonsmenda.AssignmenForCandidates;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "tourist")
@Data
public class TouristEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tourist_id")
    private int id;
    private String firstname;
    private String lastname;
    private String country;
    private String remarks;
    private String gender;

    @Column(name = "date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,
            mappedBy = "tourists")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<FlightEntity> flights;


}
