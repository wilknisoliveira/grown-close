package com.grownclose.controllers;

import com.grownclose.dto.operationtypes.OperationTypeDto;
import com.grownclose.services.OperationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/operationtypes")
public class OperationTypeController {
    @Autowired
    private OperationTypeService operationTypeService;

    @PostMapping
    public OperationTypeDto create(@RequestBody OperationTypeDto operationTypeDto) {
        return operationTypeService.save(operationTypeDto);
    }
}
