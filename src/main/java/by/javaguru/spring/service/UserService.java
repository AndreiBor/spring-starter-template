package by.javaguru.spring.service;

import by.javaguru.spring.database.repository.UserRepository;
import by.javaguru.spring.mapper.CreateUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final CreateUserMapper createUserMapper;
}
