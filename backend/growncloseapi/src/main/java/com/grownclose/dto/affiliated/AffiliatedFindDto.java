package com.grownclose.dto.affiliated;

import com.grownclose.models.Affiliated;

public record AffiliatedFindDto(
        int Id,
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
