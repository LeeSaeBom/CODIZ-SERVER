package com.gachon.codiz.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.gachon.codiz.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserId(String userId);
}
