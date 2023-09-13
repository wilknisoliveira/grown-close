package com.grownclose.application.reseller.dto;

import com.grownclose.domain.resellers.Reseller;

public record ResellerFindDto(
        int Id,
        String name,
        String email,
        String address,
        String about,
        int contactNumber,
        String instagram
) {
    public ResellerFindDto(Reseller reseller) {
        this (
                reseller.getId(),
                reseller.getName(),
                reseller.getEmail(),
                reseller.getAddress(),
                reseller.getAbout(),
                reseller.getContactNumber(),
                reseller.getInstagram()
        );
    }
}
