package com.kuijpers.demo.jpa.usermngt.controller;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountRestController.class);

    @Autowired
    private AccountService accountService;

    /**
     *
     * @return
     */
    @GetMapping(value = "/accounts", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Account> getAllAccounts() {

        return accountService.findAll();

    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/accounts/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account getAccountById(@PathVariable Long id) {

        return accountService.findById(id);

    }

    /**
     *
     * @param userName
     * @return
     */
    @GetMapping(value = "/accounts{userName}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account getAccountByUserName(@PathVariable String userName) {

        return accountService.findByUserName(userName);
    }

    /**
     *
     * @param account
     * @return
     */
    @PostMapping(value = "/accounts", consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account addAccount(@RequestBody Account account) {

        return accountService.save(account);

    }

    /**
     *
     * @param id
     * @param code
     * @return
     */
    @PutMapping(value = "/accounts/{id}/confirm/{code}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean confirmAccount(@PathVariable Long id, @PathVariable String code) {

        return accountService.confirm(id, code);

    }

    /**
     *
     * @param account
     * @return
     */
    @PutMapping(value = "/accounts", consumes =  MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account updateAccount(@RequestBody Account account) {

        return accountService.save(account);

    }

    /**
     *
     * @param id
     */
    @DeleteMapping(value = "/accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {

        Account acc = accountService.findById(id);

        accountService.delete(acc);

    }

}
