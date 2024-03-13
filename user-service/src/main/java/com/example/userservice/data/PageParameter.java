package com.example.userservice.data;

import com.example.userservice.models.ModelConstants;
import io.micrometer.common.util.StringUtils;
import lombok.*;
import org.springframework.data.domain.Sort;

@Getter
@Setter
public class PageParameter {
    private int pageNumber;
    private int pageSize;
    private String sortProperty;
    private String sortDirection;

    public PageParameter(int pageNumber, int pageSize, String sortProperty, String sortDirection) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        setSortProperty(sortProperty);
        setSortDirection(sortDirection);
    }

    public void setSortProperty(String sortProperty) {
        this.sortProperty = StringUtils.isEmpty(sortProperty) ? ModelConstants.CREATED_AT_COLUMN : sortProperty;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = StringUtils.isEmpty(sortDirection) ? Sort.Direction.DESC.name() : sortDirection;
    }

    public Sort toSort() {
        return Sort.by(Sort.Direction.fromString(sortDirection), sortProperty);
    }
}
