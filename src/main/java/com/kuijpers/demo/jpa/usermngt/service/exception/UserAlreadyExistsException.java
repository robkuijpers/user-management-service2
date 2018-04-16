package com.kuijpers.demo.jpa.usermngt.service.exception;

/**
 *
 */
public class UserAlreadyExistsException extends RuntimeException {

    public UserAlreadyExistsException(String msg) {
        super(msg);
    }

}
