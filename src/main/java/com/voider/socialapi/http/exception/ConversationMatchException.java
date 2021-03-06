package com.voider.socialapi.http.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ConversationMatchException extends RuntimeException{

    public ConversationMatchException(String message){

        super(message);
    }
}
