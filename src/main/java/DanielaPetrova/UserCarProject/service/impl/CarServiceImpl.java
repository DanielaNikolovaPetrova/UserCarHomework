package DanielaPetrova.UserCarProject.service.impl;

import DanielaPetrova.UserCarProject.converter.CarConverter;
import DanielaPetrova.UserCarProject.dto.CarAddRequest;
import DanielaPetrova.UserCarProject.dto.CarResponse;
import DanielaPetrova.UserCarProject.dto.UpdateCarRequest;
import DanielaPetrova.UserCarProject.entity.Car;
import DanielaPetrova.UserCarProject.entity.User;
import DanielaPetrova.UserCarProject.repository.CarRepository;
import DanielaPetrova.UserCarProject.repository.UserRepository;
import DanielaPetrova.UserCarProject.service.CarService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService {
    private final CarConverter carConverter;
    private final CarRepository carRepository;

    public CarServiceImpl(CarConverter carConverter, CarRepository carRepository) {
        this.carConverter = carConverter;
        this.carRepository = carRepository;
    }

    @Override
    public Car addCar(CarAddRequest request) {
        Car car = carConverter.toCar(request);
        return carRepository.save(car);
    }

    @Override
    public CarResponse getCar(Long id) {
        Car car = carRepository.findById(id).get();
        return carConverter.toResponse(car);
    }

    @Override
    public CarResponse updateCar(Long id, UpdateCarRequest request) {
        Car car = carRepository.findById(id).get();

        if(request.getBrand() != null && !request.getBrand().isBlank()){
            car.setBrand(request.getBrand());
        }
        if(request.getModel() != null && !request.getModel().isBlank()){
            car.setModel(request.getModel());
        }
        if(request.getVinNumber() != null && !request.getVinNumber().isBlank()){
            car.setVinNumber(request.getVinNumber());
        }
        if(request.getRegistrationNumber() != null && !request.getRegistrationNumber().isBlank()){
            car.setRegistrationNumber(request.getRegistrationNumber());
        }


        if (request.getUserId() != null ){
            User user = car.getUser();

           // car.setUser(request.getUserId());
        }
        return carConverter.toResponse(carRepository.save(car));
    }

    @Override
    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }
}
