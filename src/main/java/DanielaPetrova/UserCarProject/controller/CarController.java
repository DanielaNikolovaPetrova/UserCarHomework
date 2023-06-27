package DanielaPetrova.UserCarProject.controller;

import DanielaPetrova.UserCarProject.dto.CarAddRequest;
import DanielaPetrova.UserCarProject.dto.CarResponse;
import DanielaPetrova.UserCarProject.dto.UpdateCarRequest;
import DanielaPetrova.UserCarProject.entity.Car;
import DanielaPetrova.UserCarProject.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/car")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/addCar")
    public ResponseEntity<Car> addCar(@RequestBody CarAddRequest request){
        Car car = carService.addCar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(car);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarResponse> getCar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.FOUND)
                .body(carService.getCar(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CarResponse> updateCar(@PathVariable Long id, UpdateCarRequest updateCarRequest){
        CarResponse carResponse = carService.updateCar(id,updateCarRequest);
        return ResponseEntity.status(HttpStatus.OK).body(carResponse);
    }
    @DeleteMapping("/{id}")
    public HttpStatus deleteUser(@PathVariable Long id){
        carService.deleteCar(id);
        return HttpStatus.ACCEPTED;
    }
}
