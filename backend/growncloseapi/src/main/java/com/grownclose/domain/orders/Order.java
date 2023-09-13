package com.grownclose.domain.orders;

import com.grownclose.domain.deliverytypes.DeliveryType;
import com.grownclose.domain.orderstatus.OrderStatus;
import com.grownclose.domain.products.Product;
import com.grownclose.domain.resellers.Reseller;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private float amount;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DeliveryType deliveryType;

    @ManyToOne
    @JoinColumn(nullable = false)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
