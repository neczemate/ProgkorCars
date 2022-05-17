package hu.nye.progkor.cars.controller;

import hu.nye.progkor.cars.model.Car;
import hu.nye.progkor.cars.model.exception.NotFoundException;
import hu.nye.progkor.cars.service.CarService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/car-toyota")
public class CarController {

    private final CarService carService;

    public CarController(final CarService carService) {
        this.carService = carService;
    }


    @GetMapping
    public String getAllCar(final Model model){
        final List<Car> cars =carService.getAllCars();
        model.addAttribute("cars",cars);
        return "car/list";
    }
    @GetMapping("/{id}")
    public String getCar(final Model model, final  @PathVariable Long id){
        final Car car = carService.getCar(id);
        model.addAttribute("car",car);
        return "car/edit";
    }

    @PostMapping(value = "/update",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createCar(final Model model,
                            final @RequestParam(value = "Id", required = false) Long id,
                            final Car carChanges){
        final Car car = carService.updateCar(id, carChanges);
        model.addAttribute("car",car);
        return "car/edit";
    }

    @GetMapping("create")
    public String createCarForm(final Model model){
        return "car/create";
    }
    @PostMapping("create")
    public String createCar(final Model model, final Car car){
        final Car savedCar = carService.createCar(car);
        model.addAttribute("car",car);
        return "car/edit";
    }

    @GetMapping("/{id}/delete")
    public String deleteCar(final Model model, final @PathVariable("id") Long id){
        try {
            carService.deleteCar(id);
        } catch (NotFoundException e){
            //Ignored
        }
        final List<Car> cars = carService.getAllCars();
        model.addAttribute("cars",cars);
        return "car/list";
    }

}
