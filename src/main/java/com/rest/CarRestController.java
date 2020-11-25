package com.rest;

import com.dto.CarDto;
import com.mappers.CarMapper;
import com.model.Car;
import com.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarService carService;

    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carService.save(car);
    }

    @GetMapping
    public List<Car> getAllCars() {
        return carService.findAll();
    }

    @GetMapping(path = "{carId}")
    public @ResponseBody CarDto getCarById(@PathVariable("carId") Long id) {
        return CarMapper.INSTANCE.toDto(carService.find(id));
    }

    @DeleteMapping(path = "{carId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCarById(@PathVariable("carId") Long id) {
        carService.delete(id);
    }
}
