package com.nadarzy.reactiverestservice.service;

import com.nadarzy.reactiverestservice.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Disabled
@SpringBootTest
class UserClientTest {

  @Autowired UserService userService;

  @BeforeEach
  void setUp() {}

  @Test
  void testGetMessage() {
    List<User> userList = userService.getUsers(3);
    Assertions.assertEquals(3, userList.size());
  }
}
