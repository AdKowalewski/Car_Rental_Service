package com.service;

import com.exceptions.NotFoundException;
import com.model.Car;
import com.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
@Transactional
public class CarService {

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> findAll() {
        return carRepository.findAll();
    }

    public Car find(Long id) {
        return carRepository.findById(id).orElseThrow(getCarNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getCarNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Car not found: %s", id));
    }

    public Car save(Car car) {
        if(car.getId() != null) {
            final Car previousCar = find(car.getId());
            previousCar.setBrand(car.getBrand());
            previousCar.setModel(car.getModel());
            previousCar.setBodyType(car.getBodyType());
            previousCar.setProductionDate(car.getProductionDate());
            previousCar.setMileage(car.getMileage());
            previousCar.setColour(car.getColour());
            previousCar.setStatus(car.getStatus());
            previousCar.setDailyFee(car.getDailyFee());
            return carRepository.save(previousCar);
        }
        return carRepository.save(car);
    }

    public void delete(Long id) { carRepository.deleteById(id); }
}
