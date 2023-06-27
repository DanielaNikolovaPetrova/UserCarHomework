package DanielaPetrova.UserCarProject.service;

import DanielaPetrova.UserCarProject.dto.CarAddRequest;
import DanielaPetrova.UserCarProject.dto.CarResponse;
import DanielaPetrova.UserCarProject.dto.UpdateCarRequest;
import DanielaPetrova.UserCarProject.entity.Car;
import org.springframework.stereotype.Service;

@Service
public interface CarService {
    Car addCar(CarAddRequest request);
    CarResponse getCar(Long id);
    CarResponse updateCar(Long id, UpdateCarRequest request);
    void deleteCar(Long id);
}
