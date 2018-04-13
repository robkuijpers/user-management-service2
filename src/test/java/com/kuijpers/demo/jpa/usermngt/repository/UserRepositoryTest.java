package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.User;
import org.junit.Ignore;
import org.junit.Test;

import java.util.List;

/**
 *
 */
public class UserRepositoryTest {

    @Test
    @Ignore
    public void whenFindByExistingEmail_thenReturnUser() {
        //User findByEmail(String email);
    }

    @Test
    @Ignore
    public void whenFindByExistingLastName_thenReturnOneUser() {
        // List<User> findByLastName(String lastName);
    }

    @Test
    @Ignore
    public void whenFindByExistingLastNames_thenReturnMultipleUsers() {
        // List<User> findByLastName(String lastName);
    }

    @Test
    @Ignore
    public void whenFindByNotExistingLastName_thenThrowNotFoundException() {
        // List<User> findByLastName(String lastName);
    }

    @Test
    @Ignore
    public void whenFindByNotExisting_thenThrowNotFoundException() {
        // List<User> findByLastName(String lastName);
    }

}
