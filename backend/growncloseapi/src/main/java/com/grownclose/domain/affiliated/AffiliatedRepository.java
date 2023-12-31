package com.grownclose.domain.affiliated;

import com.grownclose.domain.affiliated.Affiliated;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AffiliatedRepository extends JpaRepository<Affiliated, UUID> {

}
