package repetition;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Month;

@Data
@AllArgsConstructor
public class ProjectsFounds {
    private String acronim;
    private Double budget;
    private Integer noEmployees;
    private Double percentOfFounded;
    private String category;
    private Integer numberOfMonths;

    // metoda zwracająca kwotę dofinansowanie projektu
    public Double getFoundByProject(){
        return getBudget() * (getPercentOfFounded()/100);
    }
}
