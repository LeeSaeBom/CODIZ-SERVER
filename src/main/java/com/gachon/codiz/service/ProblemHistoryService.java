package com.gachon.codiz.service;

import com.gachon.codiz.domain.ProblemHistory;
import com.gachon.codiz.repository.ProblemHistoryRepository;

import java.util.List;

public class ProblemHistoryService {

    private final ProblemHistoryRepository problemHistoryRepository;

    public ProblemHistoryService(ProblemHistoryRepository problemHistoryRepository) {
        this.problemHistoryRepository = problemHistoryRepository;
    }

    public List<ProblemHistory> findAll(String userId) {
        return problemHistoryRepository.findAllByUserId(userId);
    }

    public void insert(ProblemHistory problemHistory) {
        problemHistoryRepository.save(problemHistory);
    }
}
