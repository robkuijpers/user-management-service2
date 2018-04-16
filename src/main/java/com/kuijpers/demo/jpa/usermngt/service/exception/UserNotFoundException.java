package com.kuijpers.demo.jpa.usermngt.service.exception;

/**
 *
 */
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String msg) {
        super(msg);
    }

}
