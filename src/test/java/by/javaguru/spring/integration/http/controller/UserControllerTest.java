package by.javaguru.spring.integration.http.controller;

import by.javaguru.spring.annotation.IT;
import by.javaguru.spring.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@IT
@AutoConfigureMockMvc
@RequiredArgsConstructor
public class UserControllerTest {
    private final MockMvc mockMvc;

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("user/users"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().attribute("users", hasSize(5)));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/users")
                                .param(UserCreateEditDto.Fields.username, "test@gmail.com")
                                .param(UserCreateEditDto.Fields.firstname, "Test")
                                .param(UserCreateEditDto.Fields.lastname, "TestTest")
                                .param(UserCreateEditDto.Fields.role, "ADMIN")
                                .param(UserCreateEditDto.Fields.companyId, "1")
                                .param(UserCreateEditDto.Fields.birthDate, "01-01-2000")
//                        .param(UserCreateEditDto.Fields.birthDate, "2000-01-01")
                )
                .andExpectAll(
                        status().is3xxRedirection(),
                        redirectedUrlPattern("/users/{\\d+}")
                );
    }

}
