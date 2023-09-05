package com.grownclose.repositories;

import com.grownclose.models.Boost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoostRepository extends JpaRepository<Boost, Long> {
}
