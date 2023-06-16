package by.javaguru.spring.dto;

import by.javaguru.spring.database.entity.Role;
import by.javaguru.spring.validator.UserInfo;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo
public class UserCreateEditDto {
    @Email
    String username;



    @DateTimeFormat(pattern = "dd-MM-yyyy")
    LocalDate birthDate;


    @Size(min = 3, max = 30)
    String firstname;

    String lastname;

    Role role;

    Integer companyId;
}