package com.nadarzy.reactiverestservice.Handler;

import com.nadarzy.reactiverestservice.model.User;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

// @Component
public class UserHandler {
  //    public Mono<ServerResponse> hello(ServerRequest request) {
  //        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
  //                .body(BodyInserters.fromValue(new User("Tom")));
  //    }
}
