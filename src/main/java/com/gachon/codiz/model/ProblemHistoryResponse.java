package com.gachon.codiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.domain.ProblemHistory;

import java.util.List;

public class ProblemHistoryResponse {

    private final List<ProblemHistory> problemHistories;

    @JsonCreator
    public ProblemHistoryResponse(@JsonProperty("problemHistories") List<ProblemHistory> problemHistories) {
        this.problemHistories = problemHistories;
    }

    public List<ProblemHistory> getProblemHistories() {
        return problemHistories;
    }

    @Override
    public String toString() {
        return "ProblemHistoryResponse{" +
                "problemHistories=" + problemHistories +
                '}';
    }
}
