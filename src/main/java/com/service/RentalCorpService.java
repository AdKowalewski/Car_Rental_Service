package com.service;

import com.exceptions.NotFoundException;
import com.model.RentalCorp;
import com.repository.RentalCorpRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
@Transactional
public class RentalCorpService {

    private final RentalCorpRepository rentalCorpRepository;

    public RentalCorpService(RentalCorpRepository rentalCorpRepository) {
        this.rentalCorpRepository = rentalCorpRepository;
    }

    public List<RentalCorp> findAll() {
        return rentalCorpRepository.findAll();
    }

    public RentalCorp find(Long id) {
        return rentalCorpRepository.findById(id).orElseThrow(getRentalCorpNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getRentalCorpNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Rental Corporation not found: %s", id));
    }

    public RentalCorp save(RentalCorp rentalCorp) {
        if(rentalCorp.getId() != null) {
            final RentalCorp previousRentalCorp = find(rentalCorp.getId());
            previousRentalCorp.setName(rentalCorp.getName());
            previousRentalCorp.setInternetDomain(rentalCorp.getInternetDomain());
            previousRentalCorp.setAddress(rentalCorp.getAddress());
            previousRentalCorp.setDepartments(rentalCorp.getDepartments());
            return rentalCorpRepository.save(previousRentalCorp);
        }
        return rentalCorpRepository.save(rentalCorp);
    }

    public void delete(Long id) { rentalCorpRepository.deleteById(id); }
}
