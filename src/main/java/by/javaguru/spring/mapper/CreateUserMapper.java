package by.javaguru.spring.mapper;

import by.javaguru.spring.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreateUserMapper {
    private final CreateUserDto createUserDto;
}
