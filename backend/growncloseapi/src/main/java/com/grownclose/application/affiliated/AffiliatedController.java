package com.grownclose.application.affiliated;

import com.grownclose.application.affiliated.dto.AffiliatedFindDto;
import com.grownclose.application.affiliated.dto.AffiliatedSaveDto;
import com.grownclose.domain.affiliated.AffiliatedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/affiliated")
public class AffiliatedController {
    @Autowired
    private AffiliatedService affiliatedService;

    @PostMapping
    public AffiliatedFindDto create(@RequestBody AffiliatedSaveDto affiliatedSaveDto) {
        return affiliatedService.save(affiliatedSaveDto);
    }
}
