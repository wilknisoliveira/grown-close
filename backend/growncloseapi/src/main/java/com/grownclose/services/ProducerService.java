package com.grownclose.services;

import com.grownclose.models.Producer;
import com.grownclose.repositories.ProducerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

    private Logger logger = Logger.getLogger(ProducerService.class.getName());

    public Producer save(Producer producer) {
        logger.info("Creating a new Producer");
        return producerRepository.save(producer);
    }
}
