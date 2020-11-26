package com.controller;

import com.dto.ReservationDto;
import com.mappers.ReservationMapper;
import com.model.Reservation;
import com.service.ReservationService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public String index(Model model, @ModelAttribute("successMsg") String successMsg) {
        model.addAttribute("reservations", reservationService.findAll());
        model.addAttribute("successMsg", successMsg);
        return "reservationList";
    }

    @GetMapping("/{reservationId}")
    public String showUpdateReservationForm(Model model, @PathVariable("reservationId") Long id) {
        ReservationDto dto = ReservationMapper.INSTANCE.toDto(reservationService.find(id));
        model.addAttribute("dto", dto);
        return "updateReservation";
    }

    @PostMapping
    public ModelAndView submitUpdateReservationForm(@ModelAttribute("reservationDto") ReservationDto dto) {
        reservationService.save(ReservationMapper.INSTANCE.toEntity(dto));
        return new ModelAndView("redirect:/reservations");
    }

    @GetMapping("/createReservation")
    public String showCreateReservationForm(Model model) {
        model.addAttribute("dto", new ReservationDto());
        return "addReservation";
    }

    @PostMapping("/createReservation")
    public ModelAndView submitAddReservationForm(@ModelAttribute("reservationDto") ReservationDto dto, Model model) {
        final Reservation reservation = reservationService.save(ReservationMapper.INSTANCE.toEntity(dto));
        model.addAttribute("successMsg", String.format("Reservation with id: %s was successfully created",
                reservation.getId()));
        return new ModelAndView("redirect:/reservations", model.asMap());
    }

    @InitBinder
    public void allowEmptyDateBinding( WebDataBinder binder )
    {
        // tell spring to set empty values as null instead of empty string.
        binder.registerCustomEditor( String.class, new StringTrimmerEditor( true ));
    }
}
