package com.voider.socialapi.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class InvalidPostPermission extends RuntimeException{

    public InvalidPostPermission(String message){

        super(message);
    }
}
