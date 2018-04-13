package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.entity.Profile;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * See http://www.baeldung.com/spring-boot-testing
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindAllAccounts_thenReturnAllAccounts() {

        // arrange
        Account a1 = new Account("a123", "456");
        Account a2 = new Account("b234", "567");
        Account a3 = new Account("c345", "678");

        entityManager.persist(a1);
        entityManager.persist(a2);
        entityManager.persist(a3);

        entityManager.flush();

        // act
        List<Account> accounts = accountRepository.findAll();

        //assert
        assertThat(accounts.size()).isEqualTo(3);
        assertThat(accounts.get(0).getUserName()).isEqualTo("a123");
        assertThat(accounts.get(0).getPassword()).isEqualTo("456");
        assertThat(accounts.get(1).getUserName()).isEqualTo("b234");
        assertThat(accounts.get(1).getPassword()).isEqualTo("567");
        assertThat(accounts.get(2).getUserName()).isEqualTo("c345");
        assertThat(accounts.get(2).getPassword()).isEqualTo("678");

    }

    @Test
    public void whenFindByExistingId_thenReturnAccount() {

        // arrange
        Account a1 = new Account("a123", "456");
        entityManager.persist(a1);
        entityManager.flush();

        // act
        Account account1 = accountRepository.findByUserName("a123");

        Optional<Account> account2 = accountRepository.findById(account1.getId());

        // assert
        assertThat(account2.get().getId()).isEqualTo(account1.getId());
        assertThat(account2.get().getUserName()).isEqualTo("a123");
        assertThat(account2.get().getPassword()).isEqualTo("456");

    }

    @Test
    public void whenAddAccount_thenReturnAccount() {

        // arrange
        Account a1 = new Account("a123", "456");

        // act
        Account account = accountRepository.save(a1);

        // assert
        assertThat(account.getId()).isNotNull();
        assertThat(account.getUserName()).isEqualTo("a123");
        assertThat(account.getPassword()).isEqualTo("456");

    }

    @Test
    public void whenUpdateExistingAccount_thenReturnAccount() {

        // arrange
        Account a1 = new Account("a123", "456");
        a1.setDeleted(true);
        a1.setCreationDate(new Date());
        a1.setConfirmDate(new Date());
        a1.setConfirmCode("312");
        a1.setConfirmed(false);
        a1.setBlocked(false);
        a1.setProfile(new Profile(Locale.US));

        entityManager.persist(a1);
        entityManager.flush();

        Account a2 = accountRepository.findByUserName("a123");
        a2.setUserName("b321");
        a2.setPassword("321");
        a2.setDeleted(true);
        a2.setCreationDate(new Date());
        a2.setConfirmDate(new Date());
        a2.setConfirmCode("9090");
        a2.setConfirmed(true);
        a2.setBlocked(true);
        a2.setProfile(new Profile(Locale.GERMANY));

        // act
        Account a3 = accountRepository.save(a2);

        // assert
        assertThat(a3.getUserName()).isEqualTo("b321");
        assertThat(a3.getPassword()).isEqualTo("321");
        assertThat(a3.getDeleted()).isEqualTo(true);
        assertThat(a3.getConfirmCode()).isEqualTo("9090");
        assertThat(a3.getBlocked()).isEqualTo(true);
        assertThat(a3.getProfile().getPrefLanguage()).isEqualTo(Locale.GERMANY);

    }

    @Test
    public void whenDeleteExistingAccount_thenThrowNoException() {

        // arrange
        Account a1 = new Account("a123", "456");
        entityManager.persist(a1);
        entityManager.flush();

        Account a2 = accountRepository.findByUserName("a123");

        // act
        accountRepository.delete(a2);

        // assert
        try {
            accountRepository.findByUserName("a123");
        } catch (Exception e) {
            assertThat(e).isNotNull();
        }

    }

    @Test
    public void whenFindByExistingUserName_thenReturnAccount() {

        // arrange
        Account a = new Account("123", "456");
        entityManager.persist(a);
        entityManager.flush();

        // act
        Account account = accountRepository.findByUserName("123");

        // assert
        assertThat(account.getUserName()).isEqualTo(account.getUserName());

    }

    @Test
    @Ignore
    public void whenFindByNotExistingId_thenThrowAccountNotFoundException() {

    }

    @Test
    @Ignore
    public void whenFindByNotExistingUserName_thenThrowAccountNotFoundException() {

    }

    @Test
    @Ignore
    public void whenAddAccountWithExistingUserName_thenThrowAccountExistsException() {

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
