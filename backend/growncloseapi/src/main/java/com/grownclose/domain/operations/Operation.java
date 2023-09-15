package com.grownclose.domain.operations;

import com.grownclose.domain.affiliated.Affiliated;
import com.grownclose.domain.operationtypes.OperationType;
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
@Table(name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "VARCHAR(36)")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private UUID id;
    private LocalDateTime date;
    private float value;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Affiliated affiliated;

    @ManyToOne
    @JoinColumn(nullable = false)
    private OperationType operationType;
}
