package com.controller;

import com.dto.DepartmentDto;
import com.mappers.DepartmentMapper;
import com.model.Department;
import com.service.DepartmentService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping
    public String index(Model model, @ModelAttribute("successMsg") String successMsg) {
        model.addAttribute("departments", departmentService.findAll());
        model.addAttribute("successMsg", successMsg);
        return "departmentList";
    }

    @GetMapping("/{departmentId}")
    public String showUpdateDepartmentForm(Model model, @PathVariable("departmentId") Long id) {
        DepartmentDto dto = DepartmentMapper.INSTANCE.toDto(departmentService.find(id));
        model.addAttribute("dto", dto);
        return "updateDepartment";
    }

    @PostMapping
    public ModelAndView submitUpdateDepartmentForm(@ModelAttribute("departmentDto") DepartmentDto dto) {
        departmentService.save(DepartmentMapper.INSTANCE.toEntity(dto));
        return new ModelAndView("redirect:/departments");
    }

    @GetMapping("/createDepartment")
    public String showCreateDepartmentForm(Model model) {
        model.addAttribute("dto", new DepartmentDto());
        return "addDepartment";
    }

    @PostMapping("/createDepartment")
    public ModelAndView submitAddDepartmentForm(@ModelAttribute("departmentDto") DepartmentDto dto, Model model) {
        final Department department = departmentService.save(DepartmentMapper.INSTANCE.toEntity(dto));
        model.addAttribute("successMsg", String.format("Department with id: %s was successfully created",
                department.getId()));
        return new ModelAndView("redirect:/departments", model.asMap());
    }

    @InitBinder
    public void allowEmptyDateBinding( WebDataBinder binder )
    {
        // tell spring to set empty values as null instead of empty string.
        binder.registerCustomEditor( String.class, new StringTrimmerEditor( true ));
    }
}
