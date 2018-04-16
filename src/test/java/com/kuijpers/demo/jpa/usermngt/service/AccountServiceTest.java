package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.repository.AccountRepository;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountAlreadyExistsException;
import com.kuijpers.demo.jpa.usermngt.service.exception.AccountNotFoundException;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() {

        // Setup the mock.
        Account acc = new Account("123", "456");
        Mockito.when(accountRepository.findByUserName(acc.getUserName())).thenReturn(acc);

    }

    @TestConfiguration
    static class AccountServiceImplTestContextConfiguration {

        @Bean
        public AccountService accountService() {
            return new AccountServiceImpl();
        }

    }

    @Test
    public void whenExistingUserName_thenAccountShouldBeFound() {

        String name = "123";
        Account acc = accountService.findByUserName("123");

        assertThat(acc.getUserName()).isEqualTo(name);

    }

    @Test
    public void whenFindAccountWithNotExistingUserName_thenThrowAccountNotFoundException() {

        String userName = "123456789";

        expectedEx.expect(AccountNotFoundException.class);
        expectedEx.expectMessage("userName=" + userName);

        accountService.findByUserName(userName);

    }

    @Test
    @Ignore
    public void whenAddAccountWithExistingUserName_thenThrowAccountExistsException() {

        String userName = "111";

        Account acc1 = new Account(userName, "111");
        Account acc2 = new Account(userName, "111");

        expectedEx.expect(AccountAlreadyExistsException.class);
        expectedEx.expectMessage("userName=" + userName);

        accountService.save(acc1);
        accountService.save(acc2);

    }

    @Test
    @Ignore
    public void whenUpdateAccountWithNotExistingId_thenThrowAccountNotFoundException() {

    }

    @Test
    @Ignore
    public void whenDeleteNotExistingAccount_thenThrowAccountNotFoundException() {

    }
}
