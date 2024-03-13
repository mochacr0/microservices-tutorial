package com.example.userservice.repositories;

import com.example.userservice.models.UserEntity;
import lombok.NonNull;
import lombok.experimental.NonFinal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
    @NonNull
    Page<UserEntity> findAll(@NonNull Pageable pageable);
}
