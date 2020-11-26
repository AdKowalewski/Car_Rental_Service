package com.service;

import com.exceptions.NotFoundException;
import com.model.Car;
import com.model.Reservation;
import com.repository.ReservationRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    public Reservation find(Long id) {
        return reservationRepository.findById(id).orElseThrow(getReservationNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getReservationNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Reservation not found: %s", id));
    }

    public Reservation save(Reservation reservation) {
        if(reservation.getId() != null) {
            final Reservation previousReservation = find(reservation.getId());
            previousReservation.setCustomer(reservation.getCustomer());
            previousReservation.setCar(reservation.getCar());
            previousReservation.setReceiptDate(reservation.getReceiptDate());
            previousReservation.setReturnDate(reservation.getReturnDate());
            previousReservation.setDepartmentFrom(reservation.getDepartmentFrom());
            previousReservation.setDepartmentTo(reservation.getDepartmentTo());
            previousReservation.setTotalCost(reservation.getTotalCost());
            return reservationRepository.save(previousReservation);
        }
        return reservationRepository.save(reservation);
    }

    public void delete(Long id) { reservationRepository.deleteById(id); }
}
