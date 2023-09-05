package com.grownclose.services;

import com.grownclose.dto.affiliated.AffiliatedFindDto;
import com.grownclose.dto.affiliated.AffiliatedSaveDto;
import com.grownclose.models.Affiliated;
import com.grownclose.repositories.AffiliatedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
