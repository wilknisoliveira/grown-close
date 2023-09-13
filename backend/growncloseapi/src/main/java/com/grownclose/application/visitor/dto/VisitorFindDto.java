package com.grownclose.application.visitor.dto;

import com.grownclose.domain.visitors.Visitor;

public record VisitorFindDto(int id, String name, String email) {
    public VisitorFindDto(Visitor visitor) {
        this (
                visitor.getId(),
                visitor.getName(),
                visitor.getEmail()
        );
    }
}
