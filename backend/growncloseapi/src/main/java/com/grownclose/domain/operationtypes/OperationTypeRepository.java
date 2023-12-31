package com.grownclose.domain.operationtypes;

import com.grownclose.domain.operationtypes.OperationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationTypeRepository extends JpaRepository<OperationType, UUID> {
}
