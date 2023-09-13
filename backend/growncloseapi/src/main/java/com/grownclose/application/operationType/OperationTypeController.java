package com.grownclose.application.operationType;

import com.grownclose.application.operationType.dto.OperationTypeDto;
import com.grownclose.domain.operationtypes.OperationTypeService;
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
