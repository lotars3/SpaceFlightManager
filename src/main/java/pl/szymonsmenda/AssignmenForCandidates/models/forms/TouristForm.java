package pl.szymonsmenda.AssignmenForCandidates.models.forms;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TouristForm{

    private String firstname;
    private String lastname;
    private String country;
    private String remarks;

    private String gender;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateBirth;


}
