package com.gachon.codiz.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "mysql.users", uniqueConstraints = @UniqueConstraint(columnNames = "user_id"))
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 25)
    private String userName;

    @Column(name = "user_id", length = 12)
    private String userId;

    @Column(name = "user_email", length = 25)
    private String userEmail;

    @Column(name = "user_password", length = 25)
    private String userPassword;

    @Column(name = "user_score")
    private Long userScore;

    private User() { }

    @JsonCreator
    public User(@JsonProperty("userName") String userName,
                @JsonProperty("userId") String userId,
                @JsonProperty("userEmail") String userEmail,
                @JsonProperty("userPassword") String userPassword,
                @JsonProperty("userScore") Long userScore) {
        this.userName = userName;
        this.userId = userId;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userScore = userScore;
    }

    public Long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public Long getUserScore() {
        return userScore;
    }

    public void addScore(Long score) {
        this.userScore += score;
    }

    @Override
    public String toString() {
        return "User{" +
               "id=" + id +
               ", userName='" + userName + '\'' +
               ", userId='" + userId + '\'' +
               ", userEmail='" + userEmail + '\'' +
               ", userPassword='" + userPassword + '\'' +
               ", userScore=" + userScore +
               '}';
    }
}
