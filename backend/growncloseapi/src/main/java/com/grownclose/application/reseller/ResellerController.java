package com.grownclose.application.reseller;

import com.grownclose.application.reseller.dto.ResellerFindDto;
import com.grownclose.application.reseller.dto.ResellerSaveDto;
import com.grownclose.domain.resellers.ResellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resellers")
public class ResellerController {
    @Autowired
    private ResellerService resellerService;

    @PostMapping
    public ResellerFindDto create(@RequestBody ResellerSaveDto resellerSaveDto) {
        return resellerService.save(resellerSaveDto);
    }
}
