package com.grownclose.domain.boosts;

import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.products.Product;
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
@Table(name = "boosts", uniqueConstraints = @UniqueConstraint(columnNames = {"affiliated_id", "product_id"}))
public class Boost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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
