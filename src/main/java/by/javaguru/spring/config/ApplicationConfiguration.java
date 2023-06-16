package by.javaguru.spring.config;

import by.javaguru.spring.database.pool.ConnectionPool;
import by.javaguru.spring.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool connectionPool2(@Value("${db.driver}") String username) {
        return new ConnectionPool(username, "root", 20, "url");
    }

    @Bean
    public ConnectionPool connectionPool() {
        return new ConnectionPool("postgres", "root", 20, "url");
    }

}
