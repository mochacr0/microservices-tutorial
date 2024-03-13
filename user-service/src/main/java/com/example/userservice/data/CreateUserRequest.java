package com.example.userservice.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserRequest {
    private String username;
    private int age;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("CreateUserRequest {username= ");
        builder.append(this.username);
        builder.append(", age= ");
        builder.append(this.age);
        builder.append("}");
        return builder.toString();
    }
}
