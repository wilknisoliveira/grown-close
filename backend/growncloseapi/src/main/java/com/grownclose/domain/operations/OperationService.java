package com.grownclose.domain.operations;

import com.grownclose.application.operation.dto.OperationDto;
import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.affiliated.AffiliatedService;
import com.grownclose.domain.operationtypes.OperationType;
import com.grownclose.domain.operationtypes.OperationTypeService;
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
