package com.grownclose.services;

import com.grownclose.dto.operations.OperationDto;
import com.grownclose.models.Affiliated;
import com.grownclose.models.Operation;
import com.grownclose.models.OperationType;
import com.grownclose.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OperationService {
    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private AffiliatedService affiliatedService;

    @Autowired
    private OperationTypeService operationTypeService;

    private final Logger logger = Logger.getLogger(OperationService.class.getName());

    public OperationDto save(OperationDto operationDto) {
        logger.info("Submitting a operation...");

        Affiliated affiliated = affiliatedService.findByIdRepo(operationDto.affiliatedId());
        OperationType operationType = operationTypeService.findByIdRepo(operationDto.operationTypeId());
        Operation operation = operationDto.dtoToEntity(affiliated, operationType);

        Operation operationResponse = operationRepository.save(operation);
        OperationDto operationDtoResponse = new OperationDto(operationResponse);

        return operationDtoResponse;
    }
}
