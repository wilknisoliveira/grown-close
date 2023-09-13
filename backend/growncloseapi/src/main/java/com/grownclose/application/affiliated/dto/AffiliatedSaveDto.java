package com.grownclose.application.affiliated.dto;

import com.grownclose.domain.affiliated.Affiliated;

import java.time.LocalDateTime;

public record AffiliatedSaveDto(
        String name,
        String email,
        String password,
        String instagram,
        String facebook,
        String tiktok
) {
    public Affiliated dtoToEntity() {
        Affiliated affiliated = new Affiliated();
        affiliated.setName(this.name);
        affiliated.setEmail(this.email);
        affiliated.setPassword(this.password);
        affiliated.setDate(LocalDateTime.now());
        affiliated.setInstagram(this.instagram);
        affiliated.setFacebook(this.facebook);
        affiliated.setTiktok(this.tiktok);

        return affiliated;
    }
}
