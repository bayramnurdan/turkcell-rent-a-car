package kodlama.io.rentacar.business.dto.requests.update;

import java.sql.Timestamp;

public class UpdateMaintenanceRequest {
    private int id;

    private int car_id;

    private Timestamp sendDate;

    private Timestamp returnDate;
}
