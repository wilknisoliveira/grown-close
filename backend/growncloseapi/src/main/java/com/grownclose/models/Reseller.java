package com.grownclose.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
}
