package com.grownclose.application.affiliated.dto;

import com.grownclose.domain.affiliated.Affiliated;

import java.util.UUID;

public record AffiliatedFindDto(
        UUID id,
        String name,
        String email,
        String instagram,
        String facebook,
        String tiktok
) {
    public AffiliatedFindDto(Affiliated affiliated) {
        this (
                affiliated.getId(),
                affiliated.getName(),
                affiliated.getEmail(),
                affiliated.getInstagram(),
                affiliated.getFacebook(),
                affiliated.getTiktok()
        );
    }
}
