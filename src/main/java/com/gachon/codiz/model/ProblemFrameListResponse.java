package com.gachon.codiz.model;

import java.util.List;

import com.gachon.codiz.domain.ProblemFrame;

public class ProblemFrameListResponse {

    private List<ProblemFrame> problemFrames;

    public ProblemFrameListResponse(List<ProblemFrame> problemFrames) {
        this.problemFrames = problemFrames;
    }

    public List<ProblemFrame> getProblemFrames() {
        return problemFrames;
    }

    @Override
    public String toString() {
        return "ProblemFrameListResponse{" +
               "problemFrames=" + problemFrames +
               '}';
    }
}
