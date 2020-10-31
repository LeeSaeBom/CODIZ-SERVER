package com.gachon.codiz.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GrammerRequest {

    private final Grammer grammer;

    @JsonCreator
    public GrammerRequest(@JsonProperty("grammer") Grammer grammer) {
        this.grammer = grammer;
    }

    public Grammer getGrammer() {
        return grammer;
    }

    @Override
    public String toString() {
        return "GrammerRequest{" +
               "grammer=" + grammer +
               '}';
    }
}
