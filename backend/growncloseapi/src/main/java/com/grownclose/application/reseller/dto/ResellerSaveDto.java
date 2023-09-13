package com.grownclose.application.reseller.dto;

import com.grownclose.domain.resellers.Reseller;

public record ResellerSaveDto(
        String name,
        String email,
        String password,
        String address,
        String about,
        int contactNumber,
        String instagram
) {
    public Reseller dtoToEntity() {
        Reseller reseller = new Reseller();

        reseller.setName(this.name);
        reseller.setEmail(this.email);
        reseller.setPassword(this.password);
        reseller.setAddress(this.address);
        reseller.setAbout(this.about);
        reseller.setContactNumber(this.contactNumber);
        reseller.setInstagram(this.instagram);

        return reseller;
    }
}
