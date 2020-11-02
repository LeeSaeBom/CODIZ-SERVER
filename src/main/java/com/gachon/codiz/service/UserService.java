package com.gachon.codiz.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gachon.codiz.domain.User;
import com.gachon.codiz.exception.AlreadyExistUserException;
import com.gachon.codiz.exception.InvalidPasswordException;
import com.gachon.codiz.exception.NotFoundUserException;
import com.gachon.codiz.repository.UserRepository;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void signUp(User user) {
        String userId = user.getUserId();
        if (userRepository.findByUserId(userId).isPresent()) {
            throw new AlreadyExistUserException("이미 존재하는 유저입니다.");
        } else {
            userRepository.save(user);
        }
    }

    public void signIn(String userId, String password) {
        logger.info("This user is request. SignIn. userId = {} userPw = {}", userId, password);
        User findUser = userRepository.findByUserId(userId).orElseThrow(() -> new NotFoundUserException("해당 유저를 찾을 수 없습니다."));
        logger.info("user = {}", findUser);
        if (!findUser.getUserPassword().equals(password)) {
            throw new InvalidPasswordException("비밀번호가 맞지 않습니다.");
        }
    }

    public void update(String userId) {
        Optional<User> optUser = userRepository.findByUserId(userId);
        if (optUser.isPresent()) {
            userRepository.save(optUser.get());
        }
    }

    public void updateScore(String userId, long score) {
        Optional<User> optUser = userRepository.findByUserId(userId);
        if (optUser.isPresent()) {
            User user = optUser.get();
            user.addScore(score);
            userRepository.save(user);
        }
    }
}
