package com.grownclose.repositories;

import com.grownclose.models.Reseller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResellerRepository extends JpaRepository<Reseller, Long> {
}
