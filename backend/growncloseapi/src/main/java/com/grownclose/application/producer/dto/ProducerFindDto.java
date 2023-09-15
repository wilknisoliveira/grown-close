package com.grownclose.application.producer.dto;

import com.grownclose.domain.producers.Producer;

import java.util.UUID;

public record ProducerFindDto(
        UUID Id,
        String name,
        String email,
        String address,
        String about,
        int contactNumber,
        String instagram
) {
    public ProducerFindDto(Producer producer) {
        this(
            producer.getId(),
            producer.getName(),
            producer.getEmail(),
            producer.getAddress(),
            producer.getAbout(),
            producer.getContactNumber(),
            producer.getInstagram()
        );
    }
}
