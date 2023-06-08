package kodlama.io.rentacar.business.dto.responses.get;
import kodlama.io.rentacar.entities.enums.State;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

public class GetAllCarsResponse {
    private int id;
    private int modelId;
    private double dailyPrice;
    private int modelYear;
    private String plate;
    private State state;
}