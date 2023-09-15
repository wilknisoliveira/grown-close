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
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

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
