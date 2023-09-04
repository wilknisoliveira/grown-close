package com.grownclose.services;

import com.grownclose.dto.orders.OrderFindDto;
import com.grownclose.dto.orders.OrderSaveDto;
import com.grownclose.models.*;
import com.grownclose.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.logging.Logger;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ResellerService resellerService;

    @Autowired
    private DeliveryTypeService deliveryTypeService;

    @Autowired
    private OrderStatusService orderStatusService;

    final private Logger logger  = Logger.getLogger(OrderService.class.getName());

    public OrderFindDto save(OrderSaveDto orderSaveDto) {
        logger.info("Creating a order...");

        Order order = new Order();

        Product product =  productService.FindByIdRepo((long) orderSaveDto.productId());
        float amount = product.getPrice() * orderSaveDto.quantity();
        order.setAmount(amount);

        order.setDate(LocalDateTime.now());

        DeliveryType deliveryType = deliveryTypeService.findByIdRepo(orderSaveDto.deliveryTypeId());
        order.setDeliveryType(deliveryType);

        //The Id 1 refers to the Submited Status
        OrderStatus orderStatus = orderStatusService.findByIdRepo(1);
        order.setOrderStatus(orderStatus);

        Reseller reseller = resellerService.findByIdRepo(orderSaveDto.resellerId());
        order.setReseller(reseller);
        order.setProduct(product);

        Order orderResponse =  orderRepository.save(order);
        OrderFindDto orderFindDto = new OrderFindDto(orderResponse);
        return orderFindDto;
    }
}
