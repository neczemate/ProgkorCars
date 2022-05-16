package hu.nye.progkor.cars.controller;

import hu.nye.progkor.cars.model.Car;
import hu.nye.progkor.cars.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/car-toyota")
public class CarRestController {
    //CRUD

    private final CarService carService;

    public CarRestController(final CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @GetMapping("/{id}")
    Car getCar(final @PathVariable("id") Long id){
        return carService.getCar(id);
    }

    @PostMapping
    Car createCar(final @RequestBody Car car){
        return carService.createCar(car);
    }

    @PutMapping("/{id}")
    Car updateCar(final @PathVariable Long id,final @RequestBody Car carChange){
        return carService.updateCar(id,carChange);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCar(final @PathVariable Long id){
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
