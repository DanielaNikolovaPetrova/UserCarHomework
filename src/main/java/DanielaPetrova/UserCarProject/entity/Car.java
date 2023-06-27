package DanielaPetrova.UserCarProject.entity;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    @Column(unique = true)
    private String vinNumber;
    @Column(unique = true)
    private String registrationNumber;
    @ManyToOne
    private User user;
}
