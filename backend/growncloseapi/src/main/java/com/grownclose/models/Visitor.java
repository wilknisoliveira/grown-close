package com.grownclose.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitors")
public class Visitor extends User{

}
