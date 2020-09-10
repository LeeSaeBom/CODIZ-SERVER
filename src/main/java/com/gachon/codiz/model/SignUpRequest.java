package com.gachon.codiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.gachon.codiz.domain.User;

public class SignUpRequest {

    private final User user;

    @JsonCreator
    public SignUpRequest(@JsonProperty("user") User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "SignUpRequest{" +
               "user=" + user +
               '}';
    }
}
