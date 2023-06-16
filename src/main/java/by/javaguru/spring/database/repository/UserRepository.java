package by.javaguru.spring.database.repository;

import by.javaguru.spring.database.entity.Role;
import by.javaguru.spring.database.entity.User;
import by.javaguru.spring.dto.IPersonalInfo;
import by.javaguru.spring.dto.PersonalInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository, QuerydslPredicateExecutor<User> {

    @Query("select u from User u " +
            "where u.firstname like %:firstname% and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findAllByUsername(String username);

//    @Query("select u from User u " +
//            "where u.firstname like %:firstname% and u.lastname like %:lastname%")
//    List<User> findAllBy(String firstname, String lastname);

    List<User> findAllByFirstnameContainingAndLastnameContaining(String firsname, String lastname);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findFirstByCompanyIsNotNullOrderByIdDesc();

    List<User> findFirst3ByOrderByIdDesc();

    List<User> findFirst3By(Sort sort);

    @Query(value = "select u from User u",
    countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);


//    List<PersonalInfo> findAllByCompanyId(Integer companyId);

//    <T> List<T> findAllByCompanyId(Integer companyId, Class<T> clazz);

    @Query(value = "SELECT firstname, lastname, birth_date birthDate FROM users " +
            "WHERE company_id = :companyId",
            nativeQuery = true)
    List<IPersonalInfo> findAllByCompanyId(Integer companyId);
}
