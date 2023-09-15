package com.grownclose.domain.producers;

import com.grownclose.application.producer.dto.ProducerFindDto;
import com.grownclose.application.producer.dto.ProducerSaveDto;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ProducerService {
    @Autowired
    private ProducerRepository producerRepository;

//    @Autowired
//    private ModelMapper modelMapper;

    private Logger logger = Logger.getLogger(ProducerService.class.getName());

    public ProducerFindDto save(ProducerSaveDto producerSaveDto) {
        logger.info("Creating a new Producer");

        //Producer producer = modelMapper.map(producerDto, Producer.class);
        Producer producer = producerSaveDto.dtoToEntity();
        producer.setDate(LocalDateTime.now());
        producerRepository.save(producer);

        ProducerFindDto producerFindDto = new ProducerFindDto(producer);

        return producerFindDto;
    }

    public ProducerFindDto findById(UUID id) {
        logger.info("Reading the producer with id: " + id);
        
        ProducerFindDto producerFindDto = new ProducerFindDto(this.findByIdRepo(id));

        return producerFindDto;
    }

    public Producer findByIdRepo(UUID id) {
        Producer producer = producerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("This producer doesn't exist"));
        return producer;
    }
}
