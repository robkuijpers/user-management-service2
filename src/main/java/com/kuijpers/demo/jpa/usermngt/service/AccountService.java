package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountAlreadyExistsException;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountConfirmException;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountNotFoundException;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface AccountService {

    public List<Account> findAll() throws DataAccessException;

    public Account findById(final Long id) throws AccountNotFoundException, DataAccessException;

    public Account findByUserName(final String userName) throws AccountNotFoundException, DataAccessException;

    public Account save(final Account account) throws AccountAlreadyExistsException, AccountNotFoundException, DataAccessException;

    public Boolean confirm(final Long id, final String code) throws AccountNotFoundException, AccountConfirmException, DataAccessException;

    public void delete(final Account account) throws AccountNotFoundException, DataAccessException;

}
