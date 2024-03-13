package com.example.userservice.data;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UpdateUserRequest {
    private int age;

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("UpdateUserRequest {age= ");
        builder.append(this.age);
        builder.append("}");
        return builder.toString();
    }
}
