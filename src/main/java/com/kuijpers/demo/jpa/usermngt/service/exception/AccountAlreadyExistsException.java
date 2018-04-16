package com.kuijpers.demo.jpa.usermngt.service.exception;

/**
 *
 */
public class AccountAlreadyExistsException extends RuntimeException {

    public AccountAlreadyExistsException(String msg) {
        super(msg);
    }

}
