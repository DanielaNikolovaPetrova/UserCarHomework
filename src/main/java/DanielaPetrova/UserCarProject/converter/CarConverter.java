package DanielaPetrova.UserCarProject.converter;

import DanielaPetrova.UserCarProject.dto.CarAddRequest;
import DanielaPetrova.UserCarProject.dto.CarResponse;
import DanielaPetrova.UserCarProject.entity.Car;
import DanielaPetrova.UserCarProject.entity.User;
import DanielaPetrova.UserCarProject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {
    @Autowired
    UserRepository userRepository;
    public Car toCar(CarAddRequest request){
        User user = userRepository.findById(request.getUserId()).get();
        return Car.builder()
                .brand(request.getBrand())
                .model(request.getModel())
                .vinNumber(request.getVinNumber())
                .registrationNumber(request.getRegistrationNumber())
                .user(user)
                .build();
    }
    public CarResponse toResponse(Car savedCar){
        return new CarResponse(
                savedCar.getBrand(),
                savedCar.getModel(),
                savedCar.getRegistrationNumber(),
                savedCar.getUser().getId()
        );
    }
}
