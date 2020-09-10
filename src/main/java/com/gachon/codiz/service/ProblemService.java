package com.gachon.codiz.service;

import java.util.List;

import com.gachon.codiz.domain.Problem;
import com.gachon.codiz.domain.ProblemFrame.ProblemType;
import com.gachon.codiz.repository.ProblemRepository;

public class ProblemService {

    private final ProblemRepository problemRepository;

    public ProblemService(ProblemRepository problemRepository) {
        this.problemRepository = problemRepository;
    }

    public Problem saveProblem(Problem problem) {
        return problemRepository.save(problem);
    }

    public List<Problem> fetchProblems(Long problemId, ProblemType problemType) {
        return problemRepository.findAllByProblemIdAndProblemType(problemId, problemType);
    }
}
