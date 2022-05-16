package hu.nye.progkor.cars.service;

import hu.nye.progkor.cars.model.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    Car getCar(Long id);

    Car createCar(Car car);

    Car updateCar(Long id,Car carChange);

    void deleteCar(Long id);
}
