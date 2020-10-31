package com.gachon.codiz.service;

import java.util.List;

import com.gachon.codiz.domain.Grammer;
import com.gachon.codiz.domain.Grammer.GrammerType;
import com.gachon.codiz.repository.GrammerRepository;

public class GrammerService {

    private final GrammerRepository grammerRepository;

    public GrammerService(GrammerRepository grammerRepository) {
        this.grammerRepository = grammerRepository;
    }

    public List<Grammer> findAll() {
        return grammerRepository.findAll();
    }

    public void insert(String description, String grammerName, GrammerType grammerType) {
        grammerRepository.save(new Grammer(description, grammerType, grammerName));
    }
}
