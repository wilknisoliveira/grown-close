package com.grownclose.dto.operationtypes;

import com.grownclose.models.OperationType;

import java.time.LocalDateTime;

public record OperationTypeDto(int id, String name, String description) {
    public OperationTypeDto(OperationType operationType) {
        this (
                operationType.getId(),
                operationType.getName(),
                operationType.getDescription()
        );
    }

    public OperationType dtoToEntity() {
        OperationType operationType = new OperationType();

        operationType.setName(this.name);
        operationType.setDescription(this.description);
        operationType.setDate(LocalDateTime.now());

        return operationType;
    }
}
