package com.grownclose.controllers;

import com.grownclose.dto.visitors.VisitorFindDto;
import com.grownclose.dto.visitors.VisitorSaveDto;
import com.grownclose.services.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitors")
public class VisitorController {
    @Autowired
    private VisitorService visitorService;

    @PostMapping
    public VisitorFindDto create(@RequestBody VisitorSaveDto visitorSaveDto) {
        return visitorService.save(visitorSaveDto);
    }
}
