package com.grownclose.domain.orders;

import com.grownclose.application.order.dto.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
    @Query("SELECT new com.grownclose.application.order.dto.OrderDetail(o.id, o.amount, o.deliveryType.name, " +
            "o.orderStatus.name, o.product.name, o.product.id) " +
            "FROM Order o WHERE o.reseller.id = :resellerId")
    List<OrderDetail> findByResellerId(
            @Param("resellerId") UUID resellerId
    );
}
