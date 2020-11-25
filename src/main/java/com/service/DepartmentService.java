package com.service;

import com.exceptions.NotFoundException;
import com.model.Department;
import com.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Supplier;

@Service
@Transactional
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department find(Long id) {
        return departmentRepository.findById(id).orElseThrow(getDepartmentNotFoundExceptionSupplier(id));
    }

    private Supplier<RuntimeException> getDepartmentNotFoundExceptionSupplier(Long id) {
        return () -> new NotFoundException(String.format("Department not found: %s", id));
    }

    public Department save(Department department) {
        if(department.getId() != null) {
            final Department previousDepartment = find(department.getId());
            previousDepartment.setAddress(department.getAddress());
            previousDepartment.setWorkers(department.getWorkers());
            previousDepartment.setCars(department.getCars());
            return departmentRepository.save(previousDepartment);
        }
        return departmentRepository.save(department);
    }

    public void delete(Long id) { departmentRepository.deleteById(id); }
}
