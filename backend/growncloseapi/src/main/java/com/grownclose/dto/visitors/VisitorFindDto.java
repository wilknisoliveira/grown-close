package com.grownclose.dto.visitors;

import com.grownclose.models.Visitor;

public record VisitorFindDto(int id, String name, String email) {
    public VisitorFindDto(Visitor visitor) {
        this (
                visitor.getId(),
                visitor.getName(),
                visitor.getEmail()
        );
    }
}
