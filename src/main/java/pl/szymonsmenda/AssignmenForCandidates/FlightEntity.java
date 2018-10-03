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

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getFlightPrice() {
        return flightPrice;
    }

    public void setFlightPrice(String flightPrice) {
        this.flightPrice = flightPrice;
    }
}


