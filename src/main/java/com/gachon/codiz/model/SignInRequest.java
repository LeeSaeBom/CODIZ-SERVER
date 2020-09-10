package com.gachon.codiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SignInRequest {

    private String userId;
    private String userPasswrod;

    @JsonCreator
    public SignInRequest(@JsonProperty("userId") String userId,
                         @JsonProperty("userPassword") String userPasswrod) {
        this.userId = userId;
        this.userPasswrod = userPasswrod;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPasswrod() {
        return userPasswrod;
    }

    @Override
    public String toString() {
        return "SignInRequest{" +
               "userId='" + userId + '\'' +
               ", userPasswrod='" + userPasswrod + '\'' +
               '}';
    }
}
