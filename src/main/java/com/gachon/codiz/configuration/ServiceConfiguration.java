package com.gachon.codiz.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.gachon.codiz.repository.ProblemFrameRepository;
import com.gachon.codiz.repository.ProblemRepository;
import com.gachon.codiz.repository.UserRepository;
import com.gachon.codiz.service.ProblemFrameService;
import com.gachon.codiz.service.ProblemService;
import com.gachon.codiz.service.UserService;

@Configuration
@Import(ApplicationConfiguration.class)
public class ServiceConfiguration {

    @Bean
    public UserService userService(UserRepository userRepository) {
        return new UserService(userRepository);
    }

    @Bean
    public ProblemService problemService(ProblemRepository problemRepository) {
        return new ProblemService(problemRepository);
    }

    @Bean
    public ProblemFrameService problemFrameService(ProblemFrameRepository problemFrameRepository,
                                                   ProblemService problemService) {
        return new ProblemFrameService(problemFrameRepository, problemService);
    }
}
