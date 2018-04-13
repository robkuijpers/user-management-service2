package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.repository.AccountRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See http://www.baeldung.com/spring-boot-testing
 */
@RunWith(SpringRunner.class)
public class AccountServiceTest {

    @MockBean
    private AccountRepository accountRepository;

    @Autowired
    private AccountService accountService;

    @Before
    public void setUp() {

        // Setup the mock.
        Account acc = new Account("123", "456");
        Mockito.when(accountRepository.findByUserName(acc.getUserName())).thenReturn(acc);

    }

    @Test
    public void whenValidUserName_thenAccountShouldBeFound() {

        String name = "123";
        Account acc = accountService.findByUserName("123");

        assertThat(acc.getUserName()).isEqualTo(name);

    }

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }
    }

}
