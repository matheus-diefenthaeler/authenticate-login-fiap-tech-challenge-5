package br.com.fiap.techchallenge5authenticatelogin.controller.handler;

import br.com.fiap.techchallenge5authenticatelogin.service.exception.UserCustomException;
import br.com.fiap.techchallenge5authenticatelogin.service.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    HttpStatus status = HttpStatus.I_AM_A_TEAPOT;

    @ExceptionHandler(UserCustomException.class)
    public ResponseEntity<StandardError> entityError(
            UserCustomException e, HttpServletRequest request) {
        status = HttpStatus.BAD_REQUEST;
        var error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Bad request.");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(
            UserNotFoundException e, HttpServletRequest request) {
        status = HttpStatus.NOT_FOUND;
        var error = new StandardError();
        error.setTimestamp(Instant.now());
        error.setStatus(status.value());
        error.setError("Not found.");
        error.setMessage(e.getMessage());
        error.setPath(request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
