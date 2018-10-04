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

}
