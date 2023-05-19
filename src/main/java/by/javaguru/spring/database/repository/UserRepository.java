package by.javaguru.spring.database.repository;

import by.javaguru.spring.database.pool.ConnectionPool;
import lombok.ToString;
import org.springframework.stereotype.Repository;

@Repository

@ToString
public class UserRepository{

    public UserRepository(ConnectionPool connectionPool) {

    }
}
