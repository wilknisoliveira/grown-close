package com.grownclose.application.order;

import com.grownclose.application.order.dto.OrderDetail;
import com.grownclose.application.order.dto.OrderFindDto;
import com.grownclose.application.order.dto.OrderSaveDto;
import com.grownclose.domain.orders.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reseller/order")
public class ResellerOrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public OrderFindDto create(@RequestBody OrderSaveDto orderSaveDto) {
        return orderService.save(orderSaveDto);
    }

    @GetMapping("/list/{resellerId}")
    public List<OrderDetail> readList(@PathVariable UUID resellerId) {
        return orderService.findList(resellerId);
    }
}
