package com.grownclose.controllers;

import com.grownclose.dto.resellers.ResellerFindDto;
import com.grownclose.dto.resellers.ResellerSaveDto;
import com.grownclose.services.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resellers")
public class ResellerController {
    @Autowired
    private ResellerService resellerService;

    @PostMapping
    public ResellerFindDto create(@RequestBody ResellerSaveDto resellerSaveDto) {
        return resellerService.save(resellerSaveDto);
    }
}
