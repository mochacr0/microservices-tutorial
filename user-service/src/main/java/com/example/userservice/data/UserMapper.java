package com.example.userservice.data;

import com.example.userservice.models.UserEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {
    public User toUser(UserEntity entity) {
        return User.builder()
                .id(entity.getId().toString())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .username(entity.getUsername())
                .age(entity.getAge())
                .build();
    }

    public UserEntity toUserEntity(CreateUserRequest request) {
        return UserEntity.builder()
                .username(request.getUsername())
                .id(UUID.randomUUID())
                .age(request.getAge())
                .build();
    }
}
