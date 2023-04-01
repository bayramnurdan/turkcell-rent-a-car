package kodlama.io.rentacar.business.dto.requests.create;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import kodlama.io.rentacar.entities.enums.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCarRequest {
    private int modelYear;
    private String plate;
    private double dailyPrice;
    @Enumerated(EnumType.STRING)
    private State state; // 1 Available, 2 Rented 3 Maintenance
    private int modelId;
}
