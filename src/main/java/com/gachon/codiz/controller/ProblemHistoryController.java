package com.gachon.codiz.controller;

import com.gachon.codiz.domain.ProblemHistory;
import com.gachon.codiz.service.ProblemHistoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProblemHistoryController {

    private final ProblemHistoryService problemHistoryService;

    public ProblemHistoryController(ProblemHistoryService problemHistoryService) {
        this.problemHistoryService = problemHistoryService;
    }

    @RequestMapping(path = "/history/{userId}", method = RequestMethod.GET)
    public List<ProblemHistory> histories(@PathVariable("userId") long userId) {
        return problemHistoryService.findAll(userId);
    }

    @RequestMapping(path = "/history", method = RequestMethod.POST)
    public ResponseEntity historyPut(@RequestBody ProblemHistory problemHistory) {
        problemHistoryService.insert(problemHistory);
        return ResponseEntity.ok().build();
    }
}
