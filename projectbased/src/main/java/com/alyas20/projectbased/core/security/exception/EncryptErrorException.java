package com.alyas20.projectbased.core.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class EncryptErrorException extends RuntimeException {
    public EncryptErrorException(String message) {
        super(message);
    }
    public EncryptErrorException(String message,Throwable cause) {
        super(message, cause);
    }
}
