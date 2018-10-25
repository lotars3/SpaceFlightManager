package pl.szymonsmenda.AssignmenForCandidates.database;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@Table(name = "flight")
public class FlightEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "flight_id")
    private int id;
    @Column(name = "flight_price")
    private double flightPrice;
    @Column(name = "number_seats")
    private int numberSeats;
    @Column(name = "departure_time")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureTime;
    @Column(name = "arrival_time")
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalTime;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tourist_flight",
            joinColumns = {@JoinColumn(name = "flight_id")},
            inverseJoinColumns = {@JoinColumn(name = "tourist_id")}
    )
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Set<TouristEntity> tourists;


}


