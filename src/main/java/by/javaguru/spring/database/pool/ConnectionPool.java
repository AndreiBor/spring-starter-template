package by.javaguru.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("connectionPool1")
@ToString
public class ConnectionPool {

    private String username;
    private String password;
    private int poolSize;
    private String url;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.password}") String password,
                          @Value("${db.pool.size}") int poolSize,
                          @Value("${db.url}") String url) {
        this.username = username;
        this.password = password;
        this.poolSize = poolSize;
        this.url = url;
    }

    @PostConstruct
    private void init() {
        System.out.println("Init connection pool");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Clean connection pool");
    }
}