package com.grownclose.controllers;

import com.grownclose.dto.orderstatus.OrderStatusDto;
import com.grownclose.services.OrderStatusService;
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
