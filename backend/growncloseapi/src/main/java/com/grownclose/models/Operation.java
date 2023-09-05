package com.grownclose.models;

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
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDateTime date;
    private float value;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Affiliated affiliated;

    @ManyToOne
    @JoinColumn(nullable = false)
    private OperationType operationType;
}
