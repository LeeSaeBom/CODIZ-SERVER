package com.gachon.codiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.gachon.codiz.domain.ProblemFrame.ProblemType;
import com.gachon.codiz.model.ProblemCreateResponse;
import com.gachon.codiz.model.ProblemFrameCreateResponse;
import com.gachon.codiz.model.ProblemFrameListResponse;
import com.gachon.codiz.model.ProblemFrameRequest;
import com.gachon.codiz.model.ProblemFrameResponse;
import com.gachon.codiz.model.ProblemPutRequest;
import com.gachon.codiz.service.ProblemFrameService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/problem", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class ProblemController {

    private final ProblemFrameService problemFrameService;

    @Autowired
    public ProblemController(ProblemFrameService problemFrameService) {
        this.problemFrameService = problemFrameService;
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public ProblemFrameListResponse fetchAllProblemFrame() {
        return problemFrameService.fetchProblemFrames();
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public ProblemFrameCreateResponse createProblemFrame(@RequestBody ProblemFrameRequest problemFrameRequest) {
        return problemFrameService.createProblemFrame(problemFrameRequest.getProblemFrame());
    }

    @RequestMapping(path = "/put", method = RequestMethod.POST)
    public ProblemCreateResponse addProblemIntoProblemFrame(@RequestBody ProblemPutRequest problemPutRequest) {
        return problemFrameService.putProblemIntoProblemFrame(problemPutRequest.getProblem());
    }

    @RequestMapping(path = "/{problemId}", method = RequestMethod.GET)
    public ProblemFrameResponse fetchAllProblemFrame(@PathVariable("problemId") Long problemId) {
        return problemFrameService.getProblemFrame(problemId);
    }
}
