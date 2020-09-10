package com.gachon.codiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.domain.Problem;

public class ProblemPutRequest {

    private Problem problem;

    @JsonCreator
    public ProblemPutRequest(@JsonProperty("problem") Problem problem) {
        this.problem = problem;
    }

    public Problem getProblem() {
        return problem;
    }

    @Override
    public String toString() {
        return "ProblemPutRequest{" +
               "problem=" + problem +
               '}';
    }
}
