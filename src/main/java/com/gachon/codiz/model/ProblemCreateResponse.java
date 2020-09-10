package com.gachon.codiz.model;

import com.gachon.codiz.domain.Problem;

public class ProblemCreateResponse {

    private final Problem problem;

    public ProblemCreateResponse(Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    @Override
    public String toString() {
        return "ProblemCreateResponse{" +
               "problem=" + problem +
               '}';
    }
}
