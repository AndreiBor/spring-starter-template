package by.javaguru.spring;

import by.javaguru.spring.config.ApplicationConfiguration;
import by.javaguru.spring.database.repository.CompanyRepository;
import by.javaguru.spring.database.repository.UserRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationRunner {
    public static void main(String[] args) {
        var context =  new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//        var context =  new ClassPathXmlApplicationContext("application.xml");

//        var userRepository = context.getBean("r1", UserRepository.class);

        var companyRepository = context.getBean("companyRepository", CompanyRepository.class);
        System.out.println(companyRepository);
        context.close();
    }
}
