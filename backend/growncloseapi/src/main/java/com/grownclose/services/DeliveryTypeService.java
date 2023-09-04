package com.grownclose.services;

import com.grownclose.dto.deliverytypes.DeliveryTypeDto;
import com.grownclose.exceptions.ResourceNotFoundException;
import com.grownclose.models.DeliveryType;
import com.grownclose.repositories.DeliveryTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class DeliveryTypeService {
    @Autowired
    private DeliveryTypeRepository deliveryTypeRepository;

    private final Logger logger = Logger.getLogger(DeliveryTypeService.class.getName());

    public DeliveryTypeDto save(DeliveryTypeDto deliveryTypeDto) {
        logger.info("Creating a delivery type...");

        DeliveryType deliveryType = deliveryTypeDto.dtoToEntity();
        DeliveryType deliveryTypeResponse = deliveryTypeRepository.save(deliveryType);

        DeliveryTypeDto deliveryTypeDtoResponse = new DeliveryTypeDto(deliveryTypeResponse);

        return deliveryTypeDtoResponse;
    }

    public DeliveryType findByIdRepo(int id) {
        DeliveryType deliveryType = deliveryTypeRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("The delivery type id "+id+" doesn't exist."));
        return deliveryType;
    }
}
