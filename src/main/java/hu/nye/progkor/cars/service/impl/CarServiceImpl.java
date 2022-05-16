package hu.nye.progkor.cars.service.impl;

import hu.nye.progkor.cars.model.Car;
import hu.nye.progkor.cars.model.Equipment;
import hu.nye.progkor.cars.model.Model;
import hu.nye.progkor.cars.model.exception.NotFoundException;
import hu.nye.progkor.cars.service.CarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    private static final List<Car> DATA_BASE = new ArrayList<>();

    static {
        DATA_BASE.add(new Car(1L, Model.CHR,1.8, Equipment.COMFORT,4.2,9200000));
        DATA_BASE.add(new Car(2L, Model.CAMRY,2.2, Equipment.COMFORT,5.2,10000000));
    }

    @Override
    public List<Car> getAllCars() {
        return Collections.unmodifiableList(DATA_BASE);
    }

    @Override
    public Car getCar(final Long id) {
        return DATA_BASE.stream()
                .filter(car -> car.getId().equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

    @Override
    public Car createCar(final Car car) {
        car.setId(getNextId());
        DATA_BASE.add(car);
        return car;
    }

    @Override
    public Car updateCar(final Long id,final Car carChange) {
        final Car car = getCar(id);
        car.setModel(carChange.getModel());
        car.setMotor(carChange.getMotor());
        car.setEquipment(carChange.getEquipment());
        car.setConsumption(carChange.getConsumption());
        car.setPrice(carChange.getPrice());

        return car;
    }

    @Override
    public void deleteCar(final Long id) {
        final Car car = getCar(id);
        DATA_BASE.remove(car);

    }

    private long getNextId(){
        return getLastId() + 1L;
    }

    private long getLastId() {
        return DATA_BASE.stream()
                .mapToLong(Car::getId)
                .max()
                .orElse(0);
    }
}
