package com.gachon.codiz.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UserScoreUpdateRequest {

    private final String userId;
    private final long userScore;

    @JsonCreator
    public UserScoreUpdateRequest(@JsonProperty("userId") String userId,
                                  @JsonProperty("userScore") long userScore) {
        this.userId = userId;
        this.userScore = userScore;
    }

    public String getUserId() {
        return userId;
    }

    public long getUserScore() {
        return userScore;
    }

    @Override
    public String toString() {
        return "UserScoreUpdateRequest{" +
               "userId='" + userId + '\'' +
               ", userScore=" + userScore +
               '}';
    }
}
