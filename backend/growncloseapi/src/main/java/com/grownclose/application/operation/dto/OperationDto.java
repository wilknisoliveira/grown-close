package com.grownclose.application.operation.dto;

import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.operations.Operation;
import com.grownclose.domain.operationtypes.OperationType;

import java.time.LocalDateTime;

public record OperationDto(int id, float value, int affiliatedId, int operationTypeId) {
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
