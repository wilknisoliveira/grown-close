package com.grownclose.domain.visitors;

import com.grownclose.domain.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "visitors")
public class Visitor extends User {

}
