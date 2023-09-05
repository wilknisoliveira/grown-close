package com.grownclose.controllers;

import com.grownclose.dto.affiliated.AffiliatedFindDto;
import com.grownclose.dto.affiliated.AffiliatedSaveDto;
import com.grownclose.services.AffiliatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/affiliated")
public class AffiliatedController {
    @Autowired
    private AffiliatedService affiliatedService;

    @PostMapping
    public AffiliatedFindDto create(@RequestBody AffiliatedSaveDto affiliatedSaveDto) {
        return affiliatedService.save(affiliatedSaveDto);
    }
}
