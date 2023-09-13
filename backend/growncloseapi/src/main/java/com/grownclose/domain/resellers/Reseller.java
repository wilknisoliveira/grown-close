package com.grownclose.domain.resellers;

import com.grownclose.domain.orders.Order;
import com.grownclose.domain.users.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "resellers")
public class Reseller extends User {
    @Column(nullable = false)
    private String address;
    private String about;
    @Column(nullable = false, name = "contact_number")
    private int contactNumber;
    private String instagram;

    @OneToMany(mappedBy = "reseller", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> order = new HashSet<>();
}
