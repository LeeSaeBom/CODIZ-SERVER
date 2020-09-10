package com.gachon.codiz.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.gachon.codiz.domain.Problem;
import com.gachon.codiz.domain.ProblemFrame.ProblemType;

public interface ProblemRepository extends CrudRepository<Problem, Long> {

    List<Problem> findAllByProblemIdAndProblemType(Long problemId, ProblemType problemType);
}
