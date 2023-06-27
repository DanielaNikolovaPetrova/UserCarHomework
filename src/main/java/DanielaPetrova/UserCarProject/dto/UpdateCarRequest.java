package DanielaPetrova.UserCarProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UpdateCarRequest {
    private String brand;
    private String model;
    private String vinNumber;
    private String registrationNumber;
    private Long userId;
}
