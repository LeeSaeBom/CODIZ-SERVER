package com.gachon.codiz.configuration;

import com.gachon.codiz.repository.*;
import com.gachon.codiz.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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

    @Bean
    public GrammerService grammerService(GrammerRepository grammerRepository) {
        return new GrammerService(grammerRepository);
    }

    @Bean
    public ProblemHistoryService problemHistoryService(ProblemHistoryRepository problemHistoryRepository) {
        return new ProblemHistoryService(problemHistoryRepository);
    }
}
