package com.gachon.codiz.model;

import com.gachon.codiz.domain.ProblemFrame;

public class ProblemFrameCreateResponse {

    private ProblemFrame problemFrame;

    public ProblemFrameCreateResponse(ProblemFrame problemFrame) {
        this.problemFrame = problemFrame;
    }

    public ProblemFrame getProblemFrame() {
        return problemFrame;
    }

    @Override
    public String toString() {
        return "ProblemFrameCreateResponse{" +
               "problemFrame=" + problemFrame +
               '}';
    }
}
