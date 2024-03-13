package com.example.userservice.models;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.userservice.models.ModelConstants.*;

@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @Column(name = ID_COLUMN)
    protected UUID id;
    @CreatedDate
    @Column(name = CREATED_AT_COLUMN, updatable = false)
    protected LocalDateTime createdAt;
    @LastModifiedDate
    @Column(name = UPDATED_AT_COLUMN)
    protected LocalDateTime updatedAt;
}
