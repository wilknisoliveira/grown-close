package com.grownclose.application.deliveryType;

import com.grownclose.application.deliveryType.dto.DeliveryTypeDto;
import com.grownclose.domain.deliverytypes.DeliveryTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deliverytypes")
public class DeliveryTypeController {
    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @PostMapping
    public DeliveryTypeDto create(@RequestBody DeliveryTypeDto deliveryTypeDto) {
        return deliveryTypeService.save(deliveryTypeDto);
    }
}
