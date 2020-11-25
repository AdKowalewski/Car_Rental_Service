package com.service;

import com.repository.HireRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class HireService {

    private final HireRepository hireRepository;

    public HireService(HireRepository hireRepository) {
        this.hireRepository = hireRepository;
    }
}
