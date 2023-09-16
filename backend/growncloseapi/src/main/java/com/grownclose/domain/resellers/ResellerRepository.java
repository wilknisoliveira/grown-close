package com.grownclose.domain.resellers;

import com.grownclose.domain.resellers.Reseller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller, UUID> {
}
