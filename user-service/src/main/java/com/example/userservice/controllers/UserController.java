package com.example.userservice.controllers;

import com.example.userservice.data.CreateUserRequest;
import com.example.userservice.data.UpdateUserRequest;
import com.example.userservice.data.User;
import com.example.userservice.data.UserMapper;
import com.example.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserMapper userMapper;
    private final UserService userService;
    @GetMapping("users/status")
    public String getStatus() {
        return "User route OK";
    }

    @GetMapping("/users")
    public User getUserByUsername(@RequestParam String username) {
        return userMapper.toUser(userService.findByUsername(username));
    }

    @PostMapping("/users")
    public User createUser(@RequestBody CreateUserRequest request) {
        return userMapper.toUser(userService.insert(request));
    }

    @GetMapping("/users/{userId}")
    public User getUserById(@PathVariable String userId) {
        return userMapper.toUser(userService.findById(userId));
    }

    @PutMapping("/users/{userId}")
    public User updateUser(@PathVariable String userId, @RequestBody UpdateUserRequest request) {
        return userMapper.toUser(userService.save(userId, request));
    }
}
