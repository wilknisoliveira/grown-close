package com.grownclose.application.order;

import com.grownclose.application.order.dto.OrderFindDto;
import com.grownclose.application.order.dto.OrderSaveDto;
import com.grownclose.domain.orders.OrderService;
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
