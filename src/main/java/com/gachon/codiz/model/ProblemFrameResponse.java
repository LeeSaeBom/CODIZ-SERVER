package com.gachon.codiz.model;

import java.util.List;

import com.gachon.codiz.domain.Problem;
import com.gachon.codiz.domain.ProblemFrame;

public class ProblemFrameResponse {

    private ProblemFrame problemFrame;
    private List<Problem> problems;

    public ProblemFrameResponse(ProblemFrame problemFrame, List<Problem> problems) {
        this.problemFrame = problemFrame;
        this.problems = problems;
    }

    public ProblemFrame getProblemFrame() {
        return problemFrame;
    }

    public List<Problem> getProblems() {
        return problems;
    }

    @Override
    public String toString() {
        return "ProblemFrameResponse{" +
               "problemFrame=" + problemFrame +
               ", problems=" + problems +
               '}';
    }
}
