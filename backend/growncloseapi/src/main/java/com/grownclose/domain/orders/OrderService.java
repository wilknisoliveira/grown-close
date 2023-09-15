package com.grownclose.domain.orders;

import com.grownclose.application.order.dto.OrderFindDto;
import com.grownclose.application.order.dto.OrderSaveDto;
import com.grownclose.domain.deliverytypes.DeliveryType;
import com.grownclose.domain.deliverytypes.DeliveryTypeService;
import com.grownclose.domain.orderstatus.OrderStatus;
import com.grownclose.domain.products.Product;
import com.grownclose.domain.resellers.Reseller;
import com.grownclose.domain.orderstatus.OrderStatusService;
import com.grownclose.domain.products.ProductService;
import com.grownclose.domain.resellers.ResellerService;
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

        Product product =  productService.FindByIdRepo(orderSaveDto.productId());
        float amount = product.getPrice() * orderSaveDto.quantity();
        order.setAmount(amount);

        order.setDate(LocalDateTime.now());

        DeliveryType deliveryType = deliveryTypeService.findByIdRepo(orderSaveDto.deliveryTypeId());
        order.setDeliveryType(deliveryType);

        //It refers to the Submitted Status
        OrderStatus orderStatus = orderStatusService.findByName("Submitted");
        order.setOrderStatus(orderStatus);

        Reseller reseller = resellerService.findByIdRepo(orderSaveDto.resellerId());
        order.setReseller(reseller);
        order.setProduct(product);

        Order orderResponse =  orderRepository.save(order);
        OrderFindDto orderFindDto = new OrderFindDto(orderResponse);
        return orderFindDto;
    }
}
