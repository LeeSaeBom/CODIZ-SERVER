package com.gachon.codiz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "mysql.problem_frames")
public class ProblemFrame {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problem_name", length = 25)
    private String problemName;

    @Column(name = "problem_frame_description", length = 150)
    private String problemFrameDescription;

    @Column(name = "problem_type", length = 25)
    private ProblemType problemType;

    private ProblemFrame() {
    }

    @JsonCreator
    public ProblemFrame(@JsonProperty("problemName") String problemName,
                        @JsonProperty("problemFrameDescription") String problemFrameDescription,
                        @JsonProperty("problemType") ProblemType problemType) {
        this.problemName = problemName;
        this.problemFrameDescription = problemFrameDescription;
        this.problemType = problemType;
    }

    public Long getId() {
        return id;
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

    public enum ProblemType {
        IF,
        WHILE,
        FOR,
        FUNCTION,
        ONE_DIMENSION_ARRAY,
        MULTI_DIMENSION_ARRAY
    }

    @Override
    public String toString() {
        return "ProblemFrame{" +
               "id=" + id +
               ", problemName='" + problemName + '\'' +
               ", problemFrameDescription='" + problemFrameDescription + '\'' +
               ", problemType=" + problemType +
               '}';
    }
}
