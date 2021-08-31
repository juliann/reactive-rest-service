package com.nadarzy.reactiverestservice;

import com.nadarzy.reactiverestservice.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReactiveRestServiceApplication {

  public static void main(String[] args) {
    ConfigurableApplicationContext context =
        SpringApplication.run(ReactiveRestServiceApplication.class, args);
    UserService greetingClient = context.getBean(UserService.class);

    greetingClient.getUsers(4).forEach(System.out::println);
  }
}
