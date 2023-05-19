package by.javaguru.spring.config;

import by.javaguru.spring.database.pool.ConnectionPool;
import by.javaguru.spring.database.repository.CompanyRepository;
import by.javaguru.spring.database.repository.UserRepository;
import by.javaguru.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Import(WebConfiguration.class)
@Configuration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "by.javaguru.spring")
public class ApplicationConfiguration {

    @Bean
    public ConnectionPool connectionPool2(@Value("${db.username=}") String username) {
        return new ConnectionPool(username, "root", 20, "url");
    }

    @Bean
    public ConnectionPool connectionPool3() {
        return new ConnectionPool("postgres", "root", 20, "url");
    }

    @Bean
    public UserRepository userRepository(ConnectionPool connectionPool2) {
        return new UserRepository(connectionPool2);
    }

    @Bean
    @Profile("prod&web") // создай userRepository3 только когда профайл не прод,  prod&web
    public UserRepository userRepository3(ConnectionPool connectionPool2) {
        return new UserRepository(connectionPool3());
    }
}
