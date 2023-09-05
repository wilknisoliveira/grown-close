package com.grownclose.controllers;

import com.grownclose.dto.operations.OperationDto;
import com.grownclose.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operations")
public class OperationController {
    @Autowired
    private OperationService operationService;

    @PostMapping
    public OperationDto create(@RequestBody OperationDto operationDto) {
        return operationService.save(operationDto);
    }
}
