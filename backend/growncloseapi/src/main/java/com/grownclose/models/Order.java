package com.grownclose.models;

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

    @Column(nullable = false)
    private String deliveryTypes;

    @Column(nullable = false)
    private String status;

    @ManyToOne
    @JoinColumn(name = "reseller_id")
    private Reseller reseller;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
