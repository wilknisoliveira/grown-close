package com.grownclose.services;

import com.grownclose.dto.orderstatus.OrderStatusDto;
import com.grownclose.exceptions.ResourceNotFoundException;
import com.grownclose.models.OrderStatus;
import com.grownclose.repositories.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class OrderStatusService {
    @Autowired
    private OrderStatusRepository orderStatusRepository;

    private final Logger logger = Logger.getLogger(OrderStatusService.class.getName());

    public OrderStatusDto save(OrderStatusDto orderStatusDto) {
        logger.info("Creating a order status");

        OrderStatus orderStatus = orderStatusDto.dtoToEntity();
        OrderStatus orderStatusResponse = orderStatusRepository.save(orderStatus);

        OrderStatusDto orderStatusDtoResponse = new OrderStatusDto(orderStatusResponse);

        return orderStatusDtoResponse;
    }

    public OrderStatus findByIdRepo(int id) {
        OrderStatus orderStatus = orderStatusRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("The order status id "+id+" doesn't exist."));
        return orderStatus;
    }
}
