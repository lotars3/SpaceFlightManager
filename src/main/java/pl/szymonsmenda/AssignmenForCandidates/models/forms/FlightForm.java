package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import lombok.Data;
@Data
public class FlightForm{

    private String flightNumber;
    private String flightPrice;

//    private Date timeOfDeparture;
//    private Date timeOfArrival;


    public FlightForm() {
    }

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
