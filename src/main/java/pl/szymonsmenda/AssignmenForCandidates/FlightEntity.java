package pl.szymonsmenda.AssignmenForCandidates;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "flight")
public class FlightEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "flight_number")
    private int flightNumber;
    @Column(name = "flight_price")
    private double flightPrice;
    @Column(name = "number_seats")
    private int numberSeats;


}


