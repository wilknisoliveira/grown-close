package com.grownclose.domain.deliverytypes;

import com.grownclose.domain.deliverytypes.DeliveryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DeliveryTypeRepository extends JpaRepository<DeliveryType, UUID> {
}
