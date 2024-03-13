package com.example.userservice.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public abstract class AbstractData {
    protected String id;
    protected LocalDateTime createdAt;
    protected LocalDateTime updatedAt;
}
