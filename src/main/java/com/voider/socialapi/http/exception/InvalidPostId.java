package com.voider.socialapi.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidPostId extends RuntimeException{

    public InvalidPostId(String message){

        super(message);
    }
}
