package com.grownclose.application.producer.dto;

import com.grownclose.domain.producers.Producer;

public record ProducerSaveDto(
        String name,
        String email,
        String password,
        String address,
        String about,
        int contactNumber,
        String instagram) {

    public Producer dtoToEntity() {
        Producer producer = new Producer();

        producer.setName(this.name);
        producer.setEmail(this.email);
        producer.setPassword(this.password);
        producer.setAddress(this.address);
        producer.setAbout(this.about);
        producer.setContactNumber(this.contactNumber);
        producer.setInstagram(this.instagram);

        return producer;
    }
}
