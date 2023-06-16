package by.javaguru.spring.integration.database.repository;

import by.javaguru.spring.annotation.IT;
import by.javaguru.spring.database.entity.Role;
import by.javaguru.spring.database.repository.UserRepository;
import by.javaguru.spring.dto.PersonalInfo;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IT
@RequiredArgsConstructor
public class UserRepositoryTest {
    private final UserRepository userRepository;

    @Test
    void checkProjections() {
//        var users = userRepository.findAllByCompanyId(1, PersonalInfo.class);
        var users = userRepository.findAllByCompanyId(1);
        assertThat(users).hasSize(2);
    }

    @Test
    void findAllByFirstnameContainingAndLastnameContainingTest() {
        var user = userRepository.findAllByFirstnameContainingAndLastnameContaining("a", "a");
        assertTrue(!user.isEmpty());
        assertThat(user).hasSize(3);
    }

    @Test
    void findAllByTest() {
        var user = userRepository.findAllBy("a", "a");
        assertTrue(!user.isEmpty());
        assertThat(user).hasSize(3);
    }

    @Test
    void updateRoleTest() {
        var entity1 = userRepository.findById(1L);
        assertEquals(Role.ADMIN, entity1.get().getRole());
        var result = userRepository.updateRole(Role.USER, 1L, 5L);
        assertEquals(2, result);

        //entity1.get().getCompany().getName();
        var entity2 = userRepository.findById(1L);
        assertEquals(Role.USER, entity2.get().getRole());
    }

    @Test
    void findFirstByCompanyIsNotNullOrderByCompanyTest() {
        var user = userRepository.findFirstByCompanyIsNotNullOrderByIdDesc();
        assertTrue(user.isPresent());
        user.ifPresent(u -> assertEquals("Kate", u.getFirstname()));
    }

    @Test
    void findFirst3ByCompanyIsNotNullOrderByCompanyTest() {
        var users = userRepository.findFirst3ByOrderByIdDesc();
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }

    @Test
    void findFirst3By() {
        var users = userRepository.findFirst3By(Sort.by("firstname").and(Sort.by("lastname")).descending());
        assertTrue(!users.isEmpty());
        assertThat(users).hasSize(3);
    }

   /* @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var users = userRepository.findAllBy(pageable);
        assertThat(users).hasSize(2);
    }*/

    @Test
    void checkSlice() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(u -> System.out.println(u.getId()));

        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(u -> System.out.println(u.getId()));
        }

    }

    @Test
    void checkPage() {
        var pageable = PageRequest.of(1, 2, Sort.by("id"));
        var page = userRepository.findAllBy(pageable);
        page.forEach(u -> System.out.println(u.getId()));

        while (page.hasNext()) {
            page = userRepository.findAllBy(page.nextPageable());
            page.forEach(u -> System.out.println(u.getId()));
        }
    }

}
