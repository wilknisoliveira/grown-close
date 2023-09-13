package com.grownclose.application.orderStatus;

import com.grownclose.application.orderStatus.dto.OrderStatusDto;
import com.grownclose.domain.orderstatus.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("orderstatus")
public class OrderStatusController {
    @Autowired
    private OrderStatusService orderStatusService;

    @PostMapping
    public OrderStatusDto create(@RequestBody OrderStatusDto orderStatusDto) {
        return orderStatusService.save(orderStatusDto);
    }
}
