package com.grownclose.repositories;

import com.grownclose.models.Affiliated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffiliatedRepository extends JpaRepository<Affiliated, Long> {

}
