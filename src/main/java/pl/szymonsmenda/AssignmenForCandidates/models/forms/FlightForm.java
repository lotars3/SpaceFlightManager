package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import lombok.Data;
import com.sun.istack.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class FlightForm{

    private double flightPrice;
    private int numberSeats;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate departureTime;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate arrivalTime;






}
