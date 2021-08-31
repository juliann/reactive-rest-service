package com.nadarzy.reactiverestservice.controllers;

import com.nadarzy.reactiverestservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ServerWebExchange;

@Controller
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping({"", "/", "/index"})
  public String index() {
    return "index";
  }

  @PostMapping("/users")
  public String formPost(ServerWebExchange serverWebExchange, Model model) {

    // wild tries to extract limit and add users to model

    //    MultiValueMap<String, String> map = serverWebExchange.getFormData();
    //
    //    Integer limit = Integer.valueOf(map.get("limit").get(0));
    //
    //    if (limit == null || limit == 0) {
    //
    //      limit = 10;
    //    }
    //    var data = serverWebExchange.getFormData();
    //    Mono<String> stringMono1 =
    //        data.map(stringStringMultiValueMap -> stringStringMultiValueMap.getFirst("limit"))
    //            .publish(stringMono -> stringMono);

    //    Mono<Object> integerMono =
    //        data.map(
    //            formData -> {
    //              int parameterValue = Integer.parseInt(formData.getFirst("limit"));
    //              return Mono.just(parameterValue);
    //            });
    //
    //        ObjectMapper mapper = new ObjectMapper();
    //
    //        Mono<Integer> monoInt= Mono.just(stringMono1.map((String s) -> mapper.convertValue(s,
    // Integer.class)));
    //    model.addAttribute("users", userClient.getUsers(limit));
    //    Mono<MultiValueMap<String, String>> data = serverWebExchange.getFormData();
    //    int parameterValue = data.getFirst("limit");

    // working(-limit)
    model.addAttribute(
        "users",
        userService.getUsers(
            serverWebExchange.getFormData().map(data -> Integer.valueOf(data.getFirst("limit")))));

    return "userlist";
  }
}
