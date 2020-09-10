package com.gachon.codiz.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gachon.codiz.domain.ProblemFrame;

public interface ProblemFrameRepository extends CrudRepository<ProblemFrame, Long> {

    List<ProblemFrame> findAll();

    Optional<ProblemFrame> findProblemFrameById(Long id);
}
