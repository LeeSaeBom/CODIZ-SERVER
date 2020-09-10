package com.gachon.codiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.domain.ProblemFrame;
import com.gachon.codiz.domain.ProblemFrame.ProblemType;

public class ProblemFrameRequest {

    private String problemName;
    private String problemFrameDescription;
    private ProblemType problemType;
    private ProblemFrame problemFrame;

    @JsonCreator
    public ProblemFrameRequest(@JsonProperty("problemName") String problemName,
                               @JsonProperty("problemFrameDescription") String problemFrameDescription,
                               @JsonProperty("problemType") String problemType) {
        this.problemName = problemName;
        this.problemFrameDescription = problemFrameDescription;
        this.problemType = ProblemType.valueOf(problemType);
        problemFrame = new ProblemFrame(problemName, problemFrameDescription, this.problemType);
    }

    public String getProblemName() {
        return problemName;
    }

    public String getProblemFrameDescription() {
        return problemFrameDescription;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public ProblemFrame getProblemFrame() {
        return problemFrame;
    }

    @Override
    public String
    toString() {
        return "ProblemFrameRequest{" +
               "problemName='" + problemName + '\'' +
               ", problemFrameDescription='" + problemFrameDescription + '\'' +
               ", problemType=" + problemType +
               '}';
    }
}
