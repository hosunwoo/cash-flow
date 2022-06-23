package com.gowid.cashflow.exception;

import com.gowid.cashflow.dto.ResponseDTO;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseDTO handleSystemException(Exception e) {

        log.error(e.getMessage(), e);
        return ResponseDTO.builder()
            .result(new ResponseDTO.APIResult(ResultType.SYSTEM_ERROR))
            .build();
    }

    @ExceptionHandler(InternalServerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseDTO handleInternalServerException(InternalServerException e) {

        log.error(e.getMessage(), e);
        return new ResponseDTO(e);
    }

    @ExceptionHandler(ClientRequestException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    protected ResponseDTO handleClientRequestException(ClientRequestException e) {

        log.error(e.getMessage(), e);
        return new ResponseDTO(e);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseDTO handleMethodValidException(MethodArgumentNotValidException e) {

        log.info(e.getMessage(), e);
        return ResponseDTO.builder()
            .result(new ResponseDTO.APIResult(ResultType.INVALID_DATA,
                Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage()))
            .build();
    }

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ResponseDTO handleBadRequestException(BadRequestException e) {

        log.info(e.getMessage(), e);
        return new ResponseDTO(e);
    }

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    protected ResponseDTO handleBadRequestException(ConflictException e) {

        log.error(e.getMessage(), e);
        return new ResponseDTO(e);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ResponseDTO handleBadRequestException(NotFoundException e) {

        log.info(e.getMessage(), e);
        return new ResponseDTO(e);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    protected ResponseDTO handleUnAuthorizedException(UnAuthorizedException e) {

        log.info(e.getMessage(), e);
        return new ResponseDTO(e);
    }
}
