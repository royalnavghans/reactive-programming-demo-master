package com.reactive.client;

import com.reactive.controller.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> route(UserHandler handler) {
        return RouterFunctions
                .route(GET("/user/{id}")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::getUser);
    }

    @Bean
    public RouterFunction<ServerResponse> getAllUsers(UserHandler handler) {
        return RouterFunctions
                .route(GET("/users")
                        .and(accept(MediaType.APPLICATION_JSON)), handler::getUsers);
    }

}
