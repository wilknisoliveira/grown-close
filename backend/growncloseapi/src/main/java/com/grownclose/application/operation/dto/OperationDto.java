package com.grownclose.application.operation.dto;

import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.operations.Operation;
import com.grownclose.domain.operationtypes.OperationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record OperationDto(UUID id, float value, UUID affiliatedId, UUID operationTypeId) {
    public OperationDto(Operation operation) {
        this (
                operation.getId(),
                operation.getValue(),
                operation.getAffiliated().getId(),
                operation.getOperationType().getId()
        );
    }

    public Operation dtoToEntity(Affiliated affiliated, OperationType operationType){
        Operation operation = new Operation();
        operation.setValue(this.value);
        operation.setDate(LocalDateTime.now());
        operation.setAffiliated(affiliated);
        operation.setOperationType(operationType);

        return operation;
    }
}
