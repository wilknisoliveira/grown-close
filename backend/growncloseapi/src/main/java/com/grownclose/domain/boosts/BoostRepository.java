package com.grownclose.domain.boosts;

import com.grownclose.domain.boosts.Boost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoostRepository extends JpaRepository<Boost, Long> {
}
