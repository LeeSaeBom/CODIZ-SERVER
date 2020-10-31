package com.gachon.codiz.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.domain.Grammer;

public class GrammerResponse {

    private final List<Grammer> grammers;

    @JsonCreator
    public GrammerResponse(@JsonProperty("grammers") List<Grammer> grammers) {
        this.grammers = grammers;
    }

    public List<Grammer> getGrammers() {
        return grammers;
    }

    @Override
    public String toString() {
        return "GrammerResponse{" +
               "grammers=" + grammers +
               '}';
    }
}
