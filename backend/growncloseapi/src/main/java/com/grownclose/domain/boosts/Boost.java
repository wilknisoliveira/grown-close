package com.grownclose.domain.boosts;

import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.products.Product;
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
@Table(name = "boosts", uniqueConstraints = @UniqueConstraint(columnNames = {"affiliated_id", "product_id"}))
public class Boost {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;

    @Column(nullable = false)
    private LocalDateTime date;
    private int clickNumber;
    private float balance;

    @ManyToOne
    @JoinColumn(name = "affiliated_id")
    private Affiliated affiliated;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
