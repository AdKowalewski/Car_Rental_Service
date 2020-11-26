package com.controller;

import com.dto.RentalCorpDto;
import com.mappers.RentalCorpMapper;
import com.model.RentalCorp;
import com.service.RentalCorpService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/rentalCorps")
public class RentalCorpController {

    private final RentalCorpService rentalCorpService;

    public RentalCorpController(RentalCorpService rentalCorpService) {
        this.rentalCorpService = rentalCorpService;
    }

    @GetMapping
    public String index(Model model, @ModelAttribute("successMsg") String successMsg) {
        model.addAttribute("rentalCorps", rentalCorpService.findAll());
        model.addAttribute("successMsg", successMsg);
        return "rentalCorpList";
    }

    @GetMapping("/{rentalCorpId}")
    public String showUpdateRentalCorpForm(Model model, @PathVariable("rentalCorpId") Long id) {
        RentalCorpDto dto = RentalCorpMapper.INSTANCE.toDto(rentalCorpService.find(id));
        model.addAttribute("dto", dto);
        return "updateRentalCorp";
    }

    @PostMapping
    public ModelAndView submitUpdateRentalCorpForm(@ModelAttribute("rentalCorpDto") RentalCorpDto dto) {
        rentalCorpService.save(RentalCorpMapper.INSTANCE.toEntity(dto));
        return new ModelAndView("redirect:/rentalCorps");
    }

    @GetMapping("/createRentalCorp")
    public String showCreateRentalCorpForm(Model model) {
        model.addAttribute("dto", new RentalCorpDto());
        return "addRentalCorp";
    }

    @PostMapping("/createRentalCorp")
    public ModelAndView submitAddRentalCorpForm(@ModelAttribute("rentalCorpDto") RentalCorpDto dto, Model model) {
        final RentalCorp rentalCorp = rentalCorpService.save(RentalCorpMapper.INSTANCE.toEntity(dto));
        model.addAttribute("successMsg", String.format("Rental corporation with id: %s was successfully created",
                rentalCorp.getId()));
        return new ModelAndView("redirect:/rentalCorps", model.asMap());
    }

    @InitBinder
    public void allowEmptyDateBinding( WebDataBinder binder )
    {
        // tell spring to set empty values as null instead of empty string.
        binder.registerCustomEditor( String.class, new StringTrimmerEditor( true ));
    }
}
