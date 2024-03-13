package com.example.userservice.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.domain.Sort;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
public class PageData<T> {
    @JsonProperty("hasNext")
    private boolean hasNext;
    @Getter
    private long totalElements;
    @Getter
    private long totalPages;
    @Getter
    private List<T> data;

    public boolean hasNext() {
        return hasNext;
    }
}
