package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.repository.AccountRepository;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountAlreadyExistsException;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountConfirmException;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountNotFoundException;
import com.kuijpers.demo.jpa.usermngt.service.exception.DataException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountRepository accountRepository;

    /**
     * // @param accountRepository
     */
    public AccountServiceImpl() {
    }

    /**
     * @return
     */
    public List<Account> findAll() throws DataException {

        try {
            return this.accountRepository.findAll();
        } catch (DataException e) {
            throw new DataException(e.getMessage());
        }

    }

    /**
     * @param id
     * @return
     */
    public Account findById(final Long id) throws DataException, AccountNotFoundException {

        try {
            Optional<Account> val = this.accountRepository.findById(id);
            if (val.isPresent()) {
                return val.get();
            } else {
                throw new AccountNotFoundException("id=" + id);
            }
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataException(e.getMessage());
        }

    }

    /**
     * @param userName
     * @return
     */
    public Account findByUserName(final String userName) throws DataException {

        try {
            Account acc = this.accountRepository.findByUserName(userName);
            if (acc != null) {
                return acc;
            } else {
                throw new AccountNotFoundException("userName=" + userName);
            }
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataException(e.getMessage());
        }

    }

    /**
     * @param account
     * @return
     */
    public Account save(final Account account) throws AccountNotFoundException, AccountAlreadyExistsException, DataException {

        try {
            if (account.getId() != null) {
                this.accountRepository.findById(account.getId());
            }

            if (account.getUserName() != null) {
                if (this.findByUserName(account.getUserName()) == null) {
                    throw new AccountAlreadyExistsException("userName=" + account.getUserName());
                }
            }

            return this.accountRepository.save(account);

        } catch (AccountNotFoundException e) {
            throw e;
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataException(e.getMessage());
        }

    }

    /**
     * @param id
     * @param code
     * @return
     */
    public Boolean confirm(final Long id, final String code) throws AccountNotFoundException, AccountConfirmException, DataException {

        try {

            Account acc = this.findById(id);

            if (acc.getConfirmed() == true) {
                throw new AccountConfirmException("already confirmed");
            }

            if (acc.getConfirmCode().equals(code)) {
                this.save(acc);
                return true;
            } else {
                throw new AccountConfirmException("invalid conform code");
            }

        } catch (AccountNotFoundException e) {
            throw e;
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataException(e.getMessage());
        }

    }

    /**
     * @param account
     */
    public void delete(final Account account) throws AccountNotFoundException, DataException {

        try {
            this.findById(account.getId());
            this.accountRepository.delete(account);
        } catch (org.springframework.dao.DataAccessException e) {
            throw new DataException(e.getMessage());
        }

    }

}
