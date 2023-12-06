package com.dnnsvrmln.emailscraperservice.exception;

import com.dnnsvrmln.emailscraperservice.log.Logger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.Collections;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler({HttpClientErrorException.NotFound.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Map<String, String>> notFoundException(HttpClientErrorException.NotFound e, HttpServletRequest request) {
        var id = extractIdFromPath(request.getRequestURI());
        var errorMessage = String.format("Post with id: '%s' not found.", id);

        Logger.logError(errorMessage, e);

        return handleErrorResponseEntity(HttpStatus.NOT_FOUND, errorMessage);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, String>> badRequestException(MethodArgumentTypeMismatchException e, HttpServletRequest request) {
        var id = extractIdFromPath(request.getRequestURI());
        var errorMessage = String.format("Bad request - Id: '%s' is invalid", id);

        Logger.logError(errorMessage, e);

        return handleErrorResponseEntity(HttpStatus.BAD_REQUEST, errorMessage);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> internalServerError(Exception e) {
        var errorMessage = "Internal Server Error";
        Logger.logError(errorMessage, e);

        return handleErrorResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, errorMessage);
    }

    private String extractIdFromPath(String path) {
        String[] parts = path.split("/");
        return parts.length > 0 ? parts[parts.length - 1] : "unknown";
    }

    private ResponseEntity<Map<String, String>> handleErrorResponseEntity(HttpStatus httpStatus, String errorMessage) {
        var errorResponseBody = Collections.singletonMap("error", errorMessage);
        return ResponseEntity.status(httpStatus).header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).body(errorResponseBody);
    }

}
