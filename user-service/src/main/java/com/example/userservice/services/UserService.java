package com.example.userservice.services;

import com.example.userservice.data.CreateUserRequest;
import com.example.userservice.data.UpdateUserRequest;
import com.example.userservice.models.UserEntity;

public interface UserService {
    UserEntity findByUsername(String username);
    UserEntity insert(CreateUserRequest request);
    UserEntity findById(String userId);
    UserEntity save(String userId, UpdateUserRequest request);
}
