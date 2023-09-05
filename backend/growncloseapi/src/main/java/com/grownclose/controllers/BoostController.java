package com.grownclose.controllers;

import com.grownclose.dto.boosts.BoostDto;
import com.grownclose.services.BoostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boosts")
public class BoostController {
    @Autowired
    private BoostService boostService;

    @PostMapping
    public BoostDto create(@RequestBody BoostDto boostDto) {
        return boostService.save(boostDto);
    }
}
