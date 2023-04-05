package kodlama.io.rentacar.business.dto.responses.get;

import java.time.LocalDateTime;

public class GetAllMaintenancesResponse {
    private int id;
    private int carId;
    private String information;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
