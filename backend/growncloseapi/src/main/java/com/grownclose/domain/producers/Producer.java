package com.grownclose.domain.producers;

import com.grownclose.domain.products.Product;
import com.grownclose.domain.users.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producers")
public class Producer extends User {

    @Column(nullable = false)
    private String address;
    private String about;
    @Column(nullable = false, name = "contact_number")
    private int contactNumber;
    private String instagram;

    @OneToMany(mappedBy = "producer")
    private List<Product> products;
}
