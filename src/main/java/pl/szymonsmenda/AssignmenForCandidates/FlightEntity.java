package pl.szymonsmenda.AssignmenForCandidates;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "flight")
public class FlightEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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


}


