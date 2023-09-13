package com.grownclose.application.producer;

import com.grownclose.application.producer.dto.ProducerFindDto;
import com.grownclose.application.producer.dto.ProducerSaveDto;
import com.grownclose.domain.producers.ProducerService;
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
