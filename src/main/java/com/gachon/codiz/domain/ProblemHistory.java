package com.gachon.codiz.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "mysql.problem_history")
public class ProblemHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", length = 25)
    private String userId;

    @Column(name = "problem_name", length = 25)
    private String problemName;

    @Column(name = "problem_id")
    private Long problemId;

    @Column(name = "problem_type", length = 12)
    private ProblemFrame.ProblemType problemType;

    @Column(name = "result", length = 25)
    private Boolean result;

    private ProblemHistory() {
    }

    @JsonCreator
    public ProblemHistory(@JsonProperty("userId") String userId,
                          @JsonProperty("problemName") String problemName,
                          @JsonProperty("problemId") long problemId,
                          @JsonProperty("problemType") ProblemFrame.ProblemType problemType,
                          @JsonProperty("result") Boolean result) {
        this.userId = userId;
        this.problemName = problemName;
        this.problemId = problemId;
        this.problemType = problemType;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public String getUserId() {
        return userId;
    }

    public String getProblemName() {
        return problemName;
    }

    public Long getProblemId() {
        return problemId;
    }

    public ProblemFrame.ProblemType getProblemType() {
        return problemType;
    }

    public Boolean getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "ProblemHistory{" +
                "id=" + id +
                ", userId=" + userId +
                ", problemName='" + problemName + '\'' +
                ", problemId=" + problemId +
                ", problemType=" + problemType +
                ", result=" + result +
                '}';
    }
}
