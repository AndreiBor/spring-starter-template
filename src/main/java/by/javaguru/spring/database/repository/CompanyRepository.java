package by.javaguru.spring.database.repository;

import by.javaguru.spring.bpp.InjectBean;
import by.javaguru.spring.database.pool.ConnectionPool;
import jakarta.annotation.Resource;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@ToString
public class CompanyRepository {

    private final ConnectionPool connectionPool;
    private final List<ConnectionPool> pools;
    private final Integer poolSize;

    public CompanyRepository(@Qualifier("connectionPool2") ConnectionPool connectionPool,
                             List<ConnectionPool> pools,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.connectionPool = connectionPool;
        this.pools = pools;
        this.poolSize = poolSize;
    }
}
