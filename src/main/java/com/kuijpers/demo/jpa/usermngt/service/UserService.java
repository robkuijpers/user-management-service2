package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.User;
import com.kuijpers.demo.jpa.usermngt.service.exception.UserNotFoundException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface UserService {

    public List<User> findAll() throws DataAccessException;

    public User findByEmail(final String email) throws UserNotFoundException, DataAccessException;

    public List<User> findByLastName(final String email) throws UserNotFoundException, DataAccessException;

    public User save(final User user) throws UserNotFoundException, DataAccessException;

    public void delete(final User user) throws UserNotFoundException, DataAccessException;

}
