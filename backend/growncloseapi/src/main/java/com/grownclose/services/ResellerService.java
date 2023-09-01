package com.grownclose.services;

import com.grownclose.dto.resellers.ResellerFindDto;
import com.grownclose.dto.resellers.ResellerSaveDto;
import com.grownclose.exceptions.ResourceNotFoundException;
import com.grownclose.models.Reseller;
import com.grownclose.repositories.ResellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    public Reseller findByIdRepo(int id) {
        Reseller reseller =  resellerRepository.findById((long) id)
                .orElseThrow(() -> new ResourceNotFoundException("The reseller id "+id+" doesn't exist."));
        return reseller;
    }
}
