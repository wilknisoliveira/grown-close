package com.grownclose.domain.deliverytypes;

import com.grownclose.application.deliveryType.dto.DeliveryTypeDto;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
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

    public DeliveryType findByIdRepo(UUID id) {
        DeliveryType deliveryType = deliveryTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The delivery type id "+id+" doesn't exist."));
        return deliveryType;
    }
}
