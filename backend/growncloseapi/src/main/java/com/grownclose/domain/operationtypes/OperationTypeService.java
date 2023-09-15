package com.grownclose.domain.operationtypes;

import com.grownclose.application.operationType.dto.OperationTypeDto;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class OperationTypeService {
    @Autowired
    private OperationTypeRepository operationTypeRepository;

    private final Logger logger = Logger.getLogger(OperationTypeService.class.getName());

    public OperationTypeDto save(OperationTypeDto operationTypeDto) {
        logger.info("Creating a operation type...");

        OperationType operationType = operationTypeDto.dtoToEntity();

        OperationType operationTypeResponse = operationTypeRepository.save(operationType);

        OperationTypeDto operationTypeDtoResponse = new OperationTypeDto(operationTypeResponse);

        return operationTypeDtoResponse;
    }

    public OperationType findByIdRepo(UUID id) {
        OperationType operationType = operationTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The operation type id "+id+" doesn't exist."));

        return operationType;
    }
}
