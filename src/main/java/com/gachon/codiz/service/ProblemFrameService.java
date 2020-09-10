package com.gachon.codiz.service;

import java.util.List;

import com.gachon.codiz.domain.Problem;
import com.gachon.codiz.domain.ProblemFrame;
import com.gachon.codiz.domain.ProblemFrame.ProblemType;
import com.gachon.codiz.exception.InvalidProblemCreateException;
import com.gachon.codiz.exception.InvalidProblemTypeException;
import com.gachon.codiz.model.ProblemCreateResponse;
import com.gachon.codiz.model.ProblemFrameCreateResponse;
import com.gachon.codiz.model.ProblemFrameListResponse;
import com.gachon.codiz.model.ProblemFrameResponse;
import com.gachon.codiz.repository.ProblemFrameRepository;

public class ProblemFrameService {

    private final ProblemFrameRepository problemFrameRepository;
    private final ProblemService problemService;

    public ProblemFrameService(ProblemFrameRepository problemFrameRepository,
                               ProblemService problemService) {
        this.problemFrameRepository = problemFrameRepository;
        this.problemService = problemService;
    }

    public ProblemFrameListResponse fetchProblemFrames() {
        return new ProblemFrameListResponse(problemFrameRepository.findAll());
    }

    public ProblemFrameCreateResponse createProblemFrame(ProblemFrame problemFrame) {
        problemFrameRepository.save(problemFrame);
        return new ProblemFrameCreateResponse(problemFrame);
    }

    public ProblemCreateResponse putProblemIntoProblemFrame(Problem problem) {
        Long problemId = problem.getProblemId();
        ProblemFrame problemFrame =
                problemFrameRepository.findById(problemId)
                                      .orElseThrow(() -> new InvalidProblemCreateException("존재하지 않는 ProblemFrame 입니다."));
        problem = problemService.saveProblem(problem);
        return new ProblemCreateResponse(problem);
    }

    public ProblemFrameResponse getProblemFrame(Long problemId) {
        System.out.println(problemId);
        ProblemFrame problemFrame =
                problemFrameRepository.findById(problemId)
                                      .orElseThrow(() -> new InvalidProblemTypeException("해당 타입은 유효하지 않습니다."));
        List<Problem> problems = problemService.fetchProblems(problemFrame.getId(), problemFrame.getProblemType());
        return new ProblemFrameResponse(problemFrame, problems);
    }
}
