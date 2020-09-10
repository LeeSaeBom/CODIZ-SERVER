package com.gachon.codiz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.domain.ProblemFrame.ProblemType;

@Entity
@Table(name = "mysql.problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "problem_id")
    private Long problemId;

    @Column(name = "problem_type", length = 12)
    private ProblemType problemType;

    @Column(name = "problem_description", length = 200)
    private String problemDescription;

    @Column(name = "problem_number")
    private Long problemNumber;

    @Column(name = "problem_answer")
    private Long problemAnswer;

    @Column(name = "problem_answer_description_one", length = 150)
    private String problemAnswerDescriptionOne;

    @Column(name = "problem_answer_description_two", length = 150)
    private String problemAnswerDescriptionTwo;

    @Column(name = "problem_answer_description_three", length = 150)
    private String problemAnswerDescriptionThree;

    @Column(name = "problem_answer_description_four", length = 150)
    private String problemAnswerDescriptionFour;

    private Problem() { }

    @JsonCreator
    public Problem(@JsonProperty("problemId") Long problemId,
                   @JsonProperty("problemType") ProblemType problemType,
                   @JsonProperty("problemDescription") String problemDescription,
                   @JsonProperty("problemNumber") Long problemNumber,
                   @JsonProperty("problemAnswer") Long problemAnswer,
                   @JsonProperty("problemAnswerDescriptionOne") String problemAnswerDescriptionOne,
                   @JsonProperty("problemAnswerDescriptionTwo") String problemAnswerDescriptionTwo,
                   @JsonProperty("problemAnswerDescriptionThree") String problemAnswerDescriptionThree,
                   @JsonProperty("problemAnswerDescriptionFour") String problemAnswerDescriptionFour) {
        this.problemId = problemId;
        this.problemType = problemType;
        this.problemDescription = problemDescription;
        this.problemNumber = problemNumber;
        this.problemAnswer = problemAnswer;
        this.problemAnswerDescriptionOne = problemAnswerDescriptionOne;
        this.problemAnswerDescriptionTwo = problemAnswerDescriptionTwo;
        this.problemAnswerDescriptionThree = problemAnswerDescriptionThree;
        this.problemAnswerDescriptionFour = problemAnswerDescriptionFour;
    }

    public Long getId() {
        return id;
    }

    public Long getProblemId() {
        return problemId;
    }

    public ProblemType getProblemType() {
        return problemType;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public Long getProblemNumber() {
        return problemNumber;
    }

    public Long getProblemAnswer() {
        return problemAnswer;
    }

    public String getProblemAnswerDescriptionOne() {
        return problemAnswerDescriptionOne;
    }

    public String getProblemAnswerDescriptionTwo() {
        return problemAnswerDescriptionTwo;
    }

    public String getProblemAnswerDescriptionThree() {
        return problemAnswerDescriptionThree;
    }

    public String getProblemAnswerDescriptionFour() {
        return problemAnswerDescriptionFour;
    }

    @Override
    public String toString() {
        return "Problem{" +
               "id=" + id +
               ", problemId=" + problemId +
               ", problemType=" + problemType +
               ", problemDescription='" + problemDescription + '\'' +
               ", problemNumber=" + problemNumber +
               ", problemAnswer=" + problemAnswer +
               ", problemAnswerDescriptionOne='" + problemAnswerDescriptionOne + '\'' +
               ", problemAnswerDescriptionTwo='" + problemAnswerDescriptionTwo + '\'' +
               ", problemAnswerDescriptionThree='" + problemAnswerDescriptionThree + '\'' +
               ", problemAnswerDescriptionFour='" + problemAnswerDescriptionFour + '\'' +
               '}';
    }
}
