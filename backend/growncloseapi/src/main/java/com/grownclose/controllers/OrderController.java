package com.grownclose.controllers;

import com.grownclose.dto.orders.OrderFindDto;
import com.grownclose.dto.orders.OrderSaveDto;
import com.grownclose.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderFindDto create(@RequestBody OrderSaveDto orderSaveDto) {
        return orderService.save(orderSaveDto);
    }
}
