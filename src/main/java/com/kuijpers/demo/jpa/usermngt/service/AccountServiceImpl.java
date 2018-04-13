package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.repository.AccountRepository;
import com.kuijpers.demo.jpa.usermngt.repository.ProfileRepository;
import com.kuijpers.demo.jpa.usermngt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    private UserRepository userRepository;
    private ProfileRepository profileRepository;

    /**
     * // @param accountRepository
     */
    public AccountServiceImpl() {
        // this.accountRepository = accountRepository;
    }

    /**
     * @return
     */
    public List<Account> findAll() {

        return this.accountRepository.findAll();

    }

    /**
     * @param id
     * @return
     */
    public Account findById(final Long id) {

        Optional<Account> val = this.accountRepository.findById(id);
        if(val.isPresent()) {
            return val.get();
        } else {
            return null;
        }

    }

    /**
     * @param userName
     * @return
     */
    public Account findByUserName(final String userName) {

        return this.accountRepository.findByUserName(userName);

    }

    /**
     * @param account
     * @return
     */
    public Account save(final Account account) {

        return this.accountRepository.save(account);

    }

    /**
     * @param id
     * @param code
     * @return
     */
    public Boolean confirm(final Long id, final String code) {

        return true; // TODO this.accountRepository.save(account);

    }

    /**
     * @param account
     */
    public void delete(final Account account) {

        this.accountRepository.delete(account);

    }

}
