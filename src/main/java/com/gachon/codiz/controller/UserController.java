package com.gachon.codiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gachon.codiz.model.SignInRequest;
import com.gachon.codiz.model.SignUpRequest;
import com.gachon.codiz.model.UserScoreUpdateRequest;
import com.gachon.codiz.service.UserService;

@RestController
@RequestMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/signUp", method = RequestMethod.POST)
    public ResponseEntity signUp(@RequestBody SignUpRequest signUpRequest) {
        userService.signUp(signUpRequest.getUser());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/signIn", method = RequestMethod.POST)
    public ResponseEntity signIn(@RequestBody SignInRequest signInRequest) {
        userService.signIn(signInRequest.getUserId(), signInRequest.getUserPasswrod());
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/update/{userId}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable(name = "userId") String userId) {
        userService.update(userId);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(path = "/updateScore", method = RequestMethod.PUT)
    public ResponseEntity updateScore(@RequestBody UserScoreUpdateRequest userScoreUpdateRequest) {
        userService.updateScore(userScoreUpdateRequest.getUserId(),
                                userScoreUpdateRequest.getUserScore());
        return ResponseEntity.noContent().build();
    }
}
