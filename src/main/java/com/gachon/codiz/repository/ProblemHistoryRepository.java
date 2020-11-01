package com.gachon.codiz.repository;

import com.gachon.codiz.domain.ProblemHistory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProblemHistoryRepository extends CrudRepository<ProblemHistory, Long> {

    List<ProblemHistory> findAllByUserId(long userId);
}
