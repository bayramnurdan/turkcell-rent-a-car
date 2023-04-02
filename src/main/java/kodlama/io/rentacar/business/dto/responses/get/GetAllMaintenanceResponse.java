package kodlama.io.rentacar.business.dto.responses.get;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GetAllMaintenanceResponse {
    private int id;
    private int car_id;

    private Timestamp sendDate;

    private Timestamp returnDate;
}
