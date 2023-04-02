package kodlama.io.rentacar.business.dto.responses.update;

import kodlama.io.rentacar.entities.Car;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateMaintenanceResponse {
    private int id;

    private Car car;

    private Timestamp sendDate;

    private Timestamp returnDate;
}
