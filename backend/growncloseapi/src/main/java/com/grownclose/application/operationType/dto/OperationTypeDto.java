package com.grownclose.application.operationType.dto;

import com.grownclose.domain.operationtypes.OperationType;

import java.time.LocalDateTime;
import java.util.UUID;

public record OperationTypeDto(UUID id, String name, String description) {
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
