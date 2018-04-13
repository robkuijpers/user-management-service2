package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Account;

import java.util.List;

public interface AccountService {

    public List<Account> findAll();

    public Account findById(final Long id);

    public Account findByUserName(final String userName);

    public Account save(final Account account);

    public void delete(final Account account);

}
