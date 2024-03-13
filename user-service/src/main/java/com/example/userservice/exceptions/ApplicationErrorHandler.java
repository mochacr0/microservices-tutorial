package com.example.userservice.exceptions;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ApplicationErrorHandler extends ResponseEntityExceptionHandler {
    private final ObjectMapper objectMapper;
    private static final Map<Class<? extends Exception>, HttpStatus> exceptionToStatusMap = new HashMap<>();

    static {
        exceptionToStatusMap.put(InvalidDataException.class, HttpStatus.BAD_REQUEST);
        exceptionToStatusMap.put(IllegalArgumentException.class, HttpStatus.BAD_REQUEST);
        exceptionToStatusMap.put(ItemNotFoundException.class, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public void handle(Exception exception, HttpServletResponse response) throws IOException {
      log.error("Error: ", exception);
      if (response.isCommitted()) {
          return;
      }
      response.setStatus(exceptionToStatus(exception).value());
      response.setContentType(MediaType.APPLICATION_JSON_VALUE);
      ApplicationErrorResponse exceptionResponse = new ApplicationErrorResponse(response.getStatus(), exception.getMessage());
      objectMapper.writeValue(response.getWriter(), exceptionResponse);
    }

    private HttpStatus exceptionToStatus(Exception exception) {
        return exceptionToStatusMap.getOrDefault(exception.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(statusCode)) {
            request.setAttribute("javax.servlet.error.exception", ex, 0);
        }
        return new ResponseEntity<>(new ApplicationErrorResponse(statusCode.value(), ex), headers, statusCode);
    }
}
