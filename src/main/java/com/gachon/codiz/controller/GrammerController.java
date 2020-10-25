package com.gachon.codiz.controller;

import com.gachon.codiz.domain.Grammer;
import com.gachon.codiz.service.GrammerService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GrammerController {

    private final GrammerService grammerService;

    public GrammerController(GrammerService grammerService) {
        this.grammerService = grammerService;
    }

    @RequestMapping(path = "/grammer/list", method = RequestMethod.GET)
    public List<Grammer> getGrammerList() {
        return grammerService.findAll();
    }
}
