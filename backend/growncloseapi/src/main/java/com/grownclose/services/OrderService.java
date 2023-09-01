package com.grownclose.services;

import com.grownclose.dto.orders.OrderFindDto;
import com.grownclose.dto.orders.OrderSaveDto;
import com.grownclose.models.Order;
import com.grownclose.models.Product;
import com.grownclose.models.Reseller;
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

    final private Logger logger  = Logger.getLogger(OrderService.class.getName());

    public OrderFindDto save(OrderSaveDto orderSaveDto) {
        logger.info("Creating a order...");

        Order order = new Order();

        Product product =  productService.FindByIdRepo((long) orderSaveDto.productId());
        float amount = product.getPrice() * orderSaveDto.quantity();
        order.setAmount(amount);

        order.setDate(LocalDateTime.now());
        //Correct it: Get the delivery type by id
        order.setDeliveryTypes(orderSaveDto.deliveryTypes());
        //Correct it: Get the status by id
        order.setStatus("Submited");

        Reseller reseller = resellerService.findByIdRepo(orderSaveDto.resellerId());
        order.setReseller(reseller);
        order.setProduct(product);

        Order orderResponse =  orderRepository.save(order);
        OrderFindDto orderFindDto = new OrderFindDto(orderResponse);
        return orderFindDto;
    }
}
