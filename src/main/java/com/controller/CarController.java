package com.controller;

import com.dto.CarDto;
import com.mappers.CarMapper;
import com.model.Car;
import com.service.CarService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public String index(Model model, @ModelAttribute("successMsg") String successMsg) {
        model.addAttribute("cars", carService.findAll());
        model.addAttribute("successMsg", successMsg);
        return "carList";
    }

    @GetMapping("/{carId}")
    public String showUpdateCarForm(Model model, @PathVariable("carId") Long id) {
        CarDto dto = CarMapper.INSTANCE.toDto(carService.find(id));
        model.addAttribute("dto", dto);
        return "updateCar";
    }

    @PostMapping
    public ModelAndView submitUpdateCarForm(@ModelAttribute("dto") CarDto dto) {
        carService.save(CarMapper.INSTANCE.toEntity(dto));
        return new ModelAndView("redirect:/cars");
    }

    @GetMapping("/createCar")
    public String showCreateCarForm(Model model) {
        model.addAttribute("dto", new CarDto());
        return "addCar";
    }

    @PostMapping("/createCar")
    public ModelAndView submitAddCArForm(@ModelAttribute("dto") CarDto dto, Model model) {
        final Car car = carService.save(CarMapper.INSTANCE.toEntity(dto));
        model.addAttribute("successMsg", String.format("Car with id: %s was successfully created",
                car.getId()));
        return new ModelAndView("redirect:/cars", model.asMap());
    }

    @InitBinder
    public void allowEmptyDateBinding( WebDataBinder binder )
    {
        // tell spring to set empty values as null instead of empty string.
        binder.registerCustomEditor( String.class, new StringTrimmerEditor( true ));
    }
}
