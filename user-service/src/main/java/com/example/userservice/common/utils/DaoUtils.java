package com.example.userservice.common.utils;

import com.example.userservice.data.PageData;
import com.example.userservice.data.PageParameter;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.function.Function;

public class DaoUtils {
    public static <T, D> PageData<T> toPageData(Page<D> page, Function<D, T> toData) {
        return PageData.<T>builder()
                .hasNext(page.hasNext())
                .totalElements(page.getTotalElements())
                .totalPages(page.getTotalPages())
                .data(page.getContent().stream().map(toData).toList())
                .build();
    }

    public static Pageable toPageable(PageParameter pageParameter) {
        return PageRequest.of(pageParameter.getPageNumber(), pageParameter.getPageSize(), pageParameter.toSort());
    }
}
