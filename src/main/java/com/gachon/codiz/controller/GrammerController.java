package com.gachon.codiz.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gachon.codiz.domain.Grammer;
import com.gachon.codiz.domain.GrammerRequest;
import com.gachon.codiz.model.GrammerResponse;
import com.gachon.codiz.service.GrammerService;

@CrossOrigin(origins = "*")
@RestController
public class GrammerController {

    private final GrammerService grammerService;

    public GrammerController(GrammerService grammerService) {
        this.grammerService = grammerService;
    }

    @RequestMapping(path = "/grammer/list", method = RequestMethod.GET)
    public GrammerResponse getGrammerList() {
        return new GrammerResponse(grammerService.findAll());
    }

    @RequestMapping(path = "/grammer", method = RequestMethod.POST)
    public ResponseEntity putGrammer(@RequestBody GrammerRequest grammerRequest) {
        Grammer grammer = grammerRequest.getGrammer();
        System.out.println(grammer);
        grammerService.insert(grammer.getDescription(), grammer.getGrammerName(), grammer.getGrammerType());
        return ResponseEntity.ok().build();
    }
}
