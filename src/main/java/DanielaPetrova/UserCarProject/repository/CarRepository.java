package DanielaPetrova.UserCarProject.repository;

import DanielaPetrova.UserCarProject.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
