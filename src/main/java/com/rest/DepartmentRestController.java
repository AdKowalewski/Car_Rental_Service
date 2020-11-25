package com.rest;

import com.dto.DepartmentDto;
import com.mappers.DepartmentMapper;
import com.model.Department;
import com.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentRestController {

    private final DepartmentService departmentService;

    public DepartmentRestController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public void addDepartment(@RequestBody Department department) {
        departmentService.save(department);
    }

    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentService.findAll();
    }

    @GetMapping(path = "{departmentId}")
    public @ResponseBody
    DepartmentDto getDepartmentById(@PathVariable("departmentId") Long id) {
        return DepartmentMapper.INSTANCE.toDto(departmentService.find(id));
    }

    @DeleteMapping(path = "{departmentId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteDepartmentById(@PathVariable("departmentId") Long id) {
        departmentService.delete(id);
    }
}
