package com.grownclose.domain.visitors;

import com.grownclose.application.visitor.dto.VisitorFindDto;
import com.grownclose.application.visitor.dto.VisitorSaveDto;
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
