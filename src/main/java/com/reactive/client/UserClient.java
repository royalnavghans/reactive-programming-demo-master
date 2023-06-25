package com.reactive.client;

import com.reactive.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserClient {
    WebClient client = WebClient.builder().baseUrl("http://localhost:8080").build();

    public Mono<User> getUser() {
        return client.get().uri("/user/{id}", "1")
                .retrieve()
                .bodyToMono(User.class);
    }

    public void getUsers() {
        Flux<User> fluxUser = client.get().uri("/users")
                .retrieve()
                .bodyToFlux(User.class);
        fluxUser.subscribe(System.out::println);
    }
}
