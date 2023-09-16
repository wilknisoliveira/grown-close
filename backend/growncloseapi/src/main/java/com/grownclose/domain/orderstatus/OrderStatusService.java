package com.grownclose.domain.orderstatus;

import com.grownclose.application.orderStatus.dto.OrderStatusDto;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
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

    public OrderStatus findByName(String name) {
        OrderStatus orderStatus = orderStatusRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("The "+name+" order status doesn't exist."));
        return orderStatus;
    }
}
