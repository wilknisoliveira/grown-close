package com.grownclose.domain.producers;

import com.grownclose.domain.producers.Producer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProducerRepository extends JpaRepository<Producer, UUID> {}
