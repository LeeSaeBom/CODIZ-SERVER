package com.gachon.codiz.service;

import com.gachon.codiz.domain.Grammer;
import com.gachon.codiz.repository.GrammerRepository;

import java.util.List;

public class GrammerService {

    private final GrammerRepository grammerRepository;

    public GrammerService(GrammerRepository grammerRepository) {
        this.grammerRepository = grammerRepository;
    }

    public List<Grammer> findAll() {
        return grammerRepository.findAll();
    }
}
