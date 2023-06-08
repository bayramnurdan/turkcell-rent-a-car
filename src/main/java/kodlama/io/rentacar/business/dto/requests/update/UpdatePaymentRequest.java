package kodlama.io.rentacar.business.dto.requests.update;

import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UpdatePaymentRequest {
    @Min(value = 1)
    private double balance;
}