package com.grownclose.models;

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
@Table(name = "affiliated")
public class Affiliated extends User {
    @Column(nullable = false)
    private String instagram;
    private String facebook;
    private String tiktok;

    @Column(nullable = false)
    private float balance;

    @Column(name = "last_click_number")
    private int lastClickNumber;

    @Column(name = "clicks_day")
    private int clicksDay;

    @OneToMany(mappedBy = "affiliated", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Boost> boosts = new HashSet<>();
}
