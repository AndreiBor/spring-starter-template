package by.javaguru.spring.database.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@ToString
public class UserRepository{
    private final String userName;
    private final Integer age;
    private final List<Object> args;
    private final Map<String, Object> properties;

    @PostConstruct
    private void init() {
        System.out.println("Init UserRepository");
    }


    @PreDestroy
    private void destroy() {
        System.out.println("Clean UserRepository");
    }

}
