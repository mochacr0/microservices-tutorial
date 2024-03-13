package com.example.userservice.exceptions;

import com.fasterxml.jackson.databind.util.ExceptionUtil;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class ApplicationErrorResponse {
    private int status;
    private String message;
    private Date timestamp;
    private String stackTrace;

    public ApplicationErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = new Date();
        this.stackTrace = "";
    }

    public ApplicationErrorResponse(int status, Exception exception) {
        this.status = status;
        this.message = exception.getMessage();
        this.timestamp = new Date();
        this.stackTrace = ExceptionUtils.getStackTrace(exception);
    }
}
