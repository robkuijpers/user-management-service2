package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.User;

import java.util.List;

public interface UserService {

    public List<User> findAll();

    public User findByEmail(final String email);

    public List<User> findByLastName(final String email);

    public User save(final User user);

    public void delete(final User user);

}
