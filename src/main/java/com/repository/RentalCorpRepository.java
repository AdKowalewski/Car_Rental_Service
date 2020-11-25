package com.repository;

import com.model.RentalCorp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalCorpRepository extends JpaRepository<RentalCorp, Long> {
    
}
