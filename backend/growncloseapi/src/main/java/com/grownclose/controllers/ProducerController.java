package com.grownclose.controllers;

import com.grownclose.dto.producers.ProducerFindDto;
import com.grownclose.dto.producers.ProducerSaveDto;
import com.grownclose.models.Producer;
import com.grownclose.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producers")
public class ProducerController {
    @Autowired
    private ProducerService producerService;

    @PostMapping
    public ProducerFindDto create(@RequestBody ProducerSaveDto producerSaveDto){
        return producerService.save(producerSaveDto);
    }

    @GetMapping("/{id}")
    public ProducerFindDto ReadById(@PathVariable Long id) {
        return producerService.findById(id);
    }
}
