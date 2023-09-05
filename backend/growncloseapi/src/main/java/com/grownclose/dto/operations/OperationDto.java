package com.grownclose.dto.operations;

import com.grownclose.models.Affiliated;
import com.grownclose.models.Operation;
import com.grownclose.models.OperationType;

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
