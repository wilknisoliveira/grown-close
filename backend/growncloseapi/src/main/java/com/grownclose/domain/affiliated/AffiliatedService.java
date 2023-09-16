package com.grownclose.domain.affiliated;

import com.grownclose.application.affiliated.dto.AffiliatedFindDto;
import com.grownclose.application.affiliated.dto.AffiliatedSaveDto;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.logging.Logger;

@Service
public class AffiliatedService {
    @Autowired
    private AffiliatedRepository affiliatedRepository;

    private final Logger logger = Logger.getLogger(AffiliatedService.class.getName());

    public AffiliatedFindDto save(AffiliatedSaveDto affiliatedSaveDto) {
        logger.info("Creating an affiliated...");

        Affiliated affiliated = affiliatedSaveDto.dtoToEntity();

        Affiliated affiliatedResponse = affiliatedRepository.save(affiliated);

        AffiliatedFindDto affiliatedFindDto = new AffiliatedFindDto(affiliatedResponse);

        return affiliatedFindDto;
    }

    public Affiliated findByIdRepo(UUID id) {
        Affiliated affiliated = affiliatedRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The affiliated id "+id+" doesn't exist."));

        return affiliated;
    }
}
