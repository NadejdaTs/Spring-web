package softuni;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import softuni.service.UserService;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("benas.xml");

        UserService userService = context.getBean(UserService.class);

        System.out.println(userService.findYoungestUser()
                .orElseThrow());
    }
}
