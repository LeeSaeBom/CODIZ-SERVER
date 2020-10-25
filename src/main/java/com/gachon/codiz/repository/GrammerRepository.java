package com.gachon.codiz.repository;

import com.gachon.codiz.domain.Grammer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GrammerRepository extends CrudRepository<Grammer, Long> {

    List<Grammer> findAll();
}