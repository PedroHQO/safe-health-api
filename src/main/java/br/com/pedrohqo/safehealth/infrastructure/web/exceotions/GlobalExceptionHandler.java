package br.com.pedrohqo.safehealth.infrastructure.web.exceotions;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ProblemDetail handleIllegalArgumentException(IllegalArgumentException ex){

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

        problemDetail.setTitle("Regra de negócio violada");
        problemDetail.setType(URI.create("https://safehealth.com/erros/bad-request"));
        problemDetail.setProperty("timestamp: ", LocalDateTime.now());

        return problemDetail;
    }
}
