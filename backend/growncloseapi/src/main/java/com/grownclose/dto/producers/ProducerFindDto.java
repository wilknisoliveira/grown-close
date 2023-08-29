package com.grownclose.dto.producers;

import com.grownclose.models.Producer;

public record ProducerFindDto(
        int Id,
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
