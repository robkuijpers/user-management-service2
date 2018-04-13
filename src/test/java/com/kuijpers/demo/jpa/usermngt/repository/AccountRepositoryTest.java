package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

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
    public void whenFindByValidUserName_thenReturnAccount() {

        // arrange
        Account a = new Account("123", "456");
        entityManager.persist(a);
        entityManager.flush();

        // act
        Account account = accountRepository.findByUserName("123");

        //assert
        assertThat(account.getUserName()).isEqualTo(account.getUserName());

    }

}
