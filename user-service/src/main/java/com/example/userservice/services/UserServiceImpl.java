package com.example.userservice.services;

import com.example.userservice.data.CreateUserRequest;
import com.example.userservice.data.UpdateUserRequest;
import com.example.userservice.data.UserMapper;
import com.example.userservice.exceptions.InvalidDataException;
import com.example.userservice.exceptions.ItemNotFoundException;
import com.example.userservice.models.UserEntity;
import com.example.userservice.repositories.UserRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private static final String USER_NOT_FOUND_ERROR_MESSAGE = "User not found";

    @Override
    public UserEntity findByUsername(String username) {
        log.info(String.format("UserService findByUsername: %s", username));
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new ItemNotFoundException(USER_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public UserEntity insert(CreateUserRequest request) {
        log.info(String.format("UserService insert: %s", request));
        UserEntity userEntity = userMapper.toUserEntity(request);
        userRepository.findByUsername(userEntity.getUsername()).ifPresent(u -> {
            throw new InvalidDataException("Username already used");
        });
        return userRepository.save(userEntity);
    }

    @Override
    public UserEntity findById(String userId) {
        log.info(String.format("UserService findById: %s", userId));
        if (StringUtils.isEmpty(userId)) {
            throw new InvalidDataException("Invalid userId");
        }
        return userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ItemNotFoundException(USER_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public UserEntity save(String userId, UpdateUserRequest request) {
        log.info(String.format("UserService save: %s", request));
        if (StringUtils.isEmpty(userId)) {
            throw new InvalidDataException("Invalid userId");
        }
        UserEntity user = userRepository.findById(UUID.fromString(userId))
                .orElseThrow(() -> new ItemNotFoundException(USER_NOT_FOUND_ERROR_MESSAGE));
        user.setAge(request.getAge());
        return userRepository.save(user);
    }


}
