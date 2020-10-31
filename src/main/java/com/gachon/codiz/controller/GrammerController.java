package com.gachon.codiz.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gachon.codiz.domain.Grammer;
import com.gachon.codiz.domain.GrammerRequest;
import com.gachon.codiz.service.GrammerService;

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

    @RequestMapping(path = "/grammer", method = RequestMethod.POST)
    public ResponseEntity putGrammer(@RequestBody GrammerRequest grammerRequest) {
        Grammer grammer = grammerRequest.getGrammer();
        grammerService.insert(grammer.getDescription(), grammer.getGrammerName(), grammer.getGrammerType());
        return ResponseEntity.ok().build();
    }
}
