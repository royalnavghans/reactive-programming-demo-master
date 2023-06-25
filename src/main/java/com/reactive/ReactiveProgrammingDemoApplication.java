package com.reactive;

import com.reactive.client.UserClient;
import com.reactive.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ReactiveProgrammingDemoApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ReactiveProgrammingDemoApplication.class, args);
        UserClient client = context.getBean(UserClient.class);
        System.out.println(client.getUser());
    }

}
