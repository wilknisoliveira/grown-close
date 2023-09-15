package com.grownclose.application.visitor.dto;

import com.grownclose.domain.visitors.Visitor;

import java.util.UUID;

public record VisitorFindDto(UUID id, String name, String email) {
    public VisitorFindDto(Visitor visitor) {
        this (
                visitor.getId(),
                visitor.getName(),
                visitor.getEmail()
        );
    }
}
