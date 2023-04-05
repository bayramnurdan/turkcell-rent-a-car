package kodlama.io.rentacar.business.dto.requests.update;

import java.time.LocalDateTime;

public class UpdateMaintenanceRequest {
    private int carId;
    private String information;
    private boolean isCompleted;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
}
