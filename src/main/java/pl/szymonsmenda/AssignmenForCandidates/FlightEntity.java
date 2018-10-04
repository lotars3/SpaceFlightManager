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
    @Column(name = "flightNumber")
    private String flightNumber;
    @Column(name = "flightPrice")
    private String flightPrice;


}


