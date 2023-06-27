package DanielaPetrova.UserCarProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarResponse {
    private String brand;
    private String model;
    private String registrationNumber;
    private Long userId;
}
