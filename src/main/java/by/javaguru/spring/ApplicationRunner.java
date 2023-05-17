package by.javaguru.spring;

import by.javaguru.spring.database.repository.UserRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class ApplicationRunner {
    public static void main(String[] args) {
        var context =  new ClassPathXmlApplicationContext("application.xml");
        var userRepository = context.getBean("r1", UserRepository.class);
        System.out.println(userRepository);
        context.close();
    }
}
