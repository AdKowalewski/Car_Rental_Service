package com.rest;

import com.dto.ReservationDto;
import com.mappers.ReservationMapper;
import com.model.Reservation;
import com.service.ReservationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationRestController {

    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public void addReservation(@RequestBody Reservation reservation) {
        reservationService.save(reservation);
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.findAll();
    }

    @GetMapping(path = "{reservationId}")
    public @ResponseBody
    ReservationDto getReservationById(@PathVariable("reservationId") Long id) {
        return ReservationMapper.INSTANCE.toDto(reservationService.find(id));
    }

    @DeleteMapping(path = "{reservationId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteReservationById(@PathVariable("reservationId") Long id) {
        reservationService.delete(id);
    }

}
