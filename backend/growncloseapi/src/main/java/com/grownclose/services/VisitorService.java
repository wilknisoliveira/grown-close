package com.grownclose.services;

import com.grownclose.dto.visitors.VisitorFindDto;
import com.grownclose.dto.visitors.VisitorSaveDto;
import com.grownclose.models.Visitor;
import com.grownclose.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class VisitorService {
    @Autowired
    private VisitorRepository visitorRepository;

    private final Logger logger = Logger.getLogger(VisitorService.class.getName());

    public VisitorFindDto save(VisitorSaveDto visitorSaveDto) {
        logger.info("Creating a visitor...");

        Visitor visitor = visitorRepository.save(visitorSaveDto.dtoToEntity());

        return new VisitorFindDto(visitor);
    }
}
