package com.grownclose.domain.products;

import com.grownclose.application.product.dto.ProductResumeDto;

import jakarta.websocket.server.PathParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT new com.grownclose.application.product.dto.ProductResumeDto(p.id, p.name, p.price, " +
            "(SELECT COALESCE(SUM(o.amount), 0) FROM Order o WHERE o.product.id = p.id), " +
            "(SELECT COALESCE(AVG(r.vote), 0) FROM Review r WHERE r.product.id = p.id)) " +
            "FROM Product p " +
            "WHERE p.producer.id = :producerId ")
    public List<ProductResumeDto> getResumeList(
      @PathParam("producerId") int producerId
    );

}
