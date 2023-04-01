package kodlama.io.rentacar.business.dto.requests.update;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kodlama.io.rentacar.entities.Model;
import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCarRequest {
    private int id;
    private int modelYear;
    private String plate;
    private double dailyPrice;
    @Enumerated(EnumType.STRING)
    private State state;
    private Model model;
}
