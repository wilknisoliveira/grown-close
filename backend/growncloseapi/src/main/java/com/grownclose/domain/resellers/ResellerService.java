package com.grownclose.domain.resellers;

import com.grownclose.application.reseller.dto.ResellerFindDto;
import com.grownclose.application.reseller.dto.ResellerSaveDto;
import com.grownclose.infrastructure.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.logging.Logger;

@Service
public class ResellerService {
    @Autowired
    private ResellerRepository resellerRepository;

    final private Logger logger = Logger.getLogger(ResellerService.class.getName());

    public ResellerFindDto save(ResellerSaveDto resellerSaveDto) {
        logger.info("Creating a reseller...");

        Reseller reseller = resellerSaveDto.dtoToEntity();
        reseller.setDate(LocalDateTime.now());
        Reseller resellerResponse = resellerRepository.save(reseller);

        ResellerFindDto resellerFindDto = new ResellerFindDto(resellerResponse);
        return resellerFindDto;
    }

    public Reseller findByIdRepo(UUID id) {
        Reseller reseller =  resellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("The reseller id "+id+" doesn't exist."));
        return reseller;
    }
}
