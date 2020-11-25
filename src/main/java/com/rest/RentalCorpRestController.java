package com.rest;

import com.dto.RentalCorpDto;
import com.mappers.RentalCorpMapper;
import com.model.RentalCorp;
import com.service.RentalCorpService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentalCorps")
public class RentalCorpRestController {

    private final RentalCorpService rentalCorpService;

    public RentalCorpRestController(RentalCorpService rentalCorpService) {
        this.rentalCorpService = rentalCorpService;
    }

    @PostMapping
    public void addRentalCorp(@RequestBody RentalCorp rentalCorp) {
        rentalCorpService.save(rentalCorp);
    }

    @GetMapping
    public List<RentalCorp> getAllRentalCorps() {
        return rentalCorpService.findAll();
    }

    @GetMapping(path = "{rentalCorpId}")
    public @ResponseBody
    RentalCorpDto getRentalCorpById(@PathVariable("rentalCorpId") Long id) {
        return RentalCorpMapper.INSTANCE.toDto(rentalCorpService.find(id));
    }

    @DeleteMapping(path = "{rentalCorpId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRentalCorpById(@PathVariable("rentalCorpId") Long id) {
        rentalCorpService.delete(id);
    }
}
