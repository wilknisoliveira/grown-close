package com.grownclose.application.visitor.dto;

import com.grownclose.domain.visitors.Visitor;

import java.time.LocalDateTime;

public record VisitorSaveDto(String name, String email, String password) {
    public Visitor dtoToEntity() {
        Visitor visitor = new Visitor();
        visitor.setName(this.name);
        visitor.setDate(LocalDateTime.now());
        visitor.setEmail(this.email);
        visitor.setPassword(this.password);

        return visitor;
    }
}
