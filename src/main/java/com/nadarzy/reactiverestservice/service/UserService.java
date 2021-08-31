package com.nadarzy.reactiverestservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nadarzy.reactiverestservice.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {

  private final WebClient client;

  @Value("${api.url}")
  private final String API_URL;
  // Spring Boot auto-configures a `WebClient.Builder` instance with nice defaults and
  // customizations.
  // We can use it to create a dedicated `WebClient` for our component.

  public UserService(WebClient.Builder builder, @Value("${api.url}") String url) {
    API_URL = url;
    this.client = builder.baseUrl(API_URL).build();
  }

  public Flux<User> getUsers(Mono<Integer> limit) {
    //    return WebClient.create(API_URL)
    //        .get()
    //        .uri(uriBuilder -> uriBuilder.queryParam("limit", 1).build())
    //        .accept(MediaType.APPLICATION_JSON)
    //        .retrieve()
    //        .bodyToMono(User.class);
    System.out.println("#############" + limit.subscribe());
    return client.get().uri("/users?_limit=" + 5).retrieve().bodyToFlux(User.class);
  }

  public List<User> getUsers(int limit) {
    Mono<Object[]> response =
        this.client
            .get()
            .uri("/users?_limit=" + limit)
            .accept(MediaType.APPLICATION_JSON)
            .retrieve()
            .bodyToMono(Object[].class)
            .log();
    Object[] objects = response.block();
    ObjectMapper mapper = new ObjectMapper();

    return Arrays.stream(objects)
        .map(object -> mapper.convertValue(object, User.class))
        .collect(Collectors.toList());
  }

  //    public Mono<String> getMessage() {
  //        return this.client.get().uri("/hello").accept(MediaType.APPLICATION_JSON)
  //                .retrieve()
  //                .bodyToMono(User.class)
  //                .map(User::getUsername);
  //    }
}
