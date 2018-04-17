package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.Profile;
import com.kuijpers.demo.jpa.usermngt.entity.User;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private TestEntityManager entityManager;
    @Test
    public void whenFindByExistingEmail_thenReturnUser() {

        // arrange
        User u1 = new User("user1@home.nl");
        entityManager.persist(u1);
        entityManager.flush();

        // act
        Optional<User> u2  = userRepository.findById(u1.getId());

        // assert
        assertThat(u2.isPresent()).isTrue();
        assertThat(u2.get().getId()).isEqualTo(u1.getId());

    }

    @Test
    public void whenFindByExistingEmail_thenReturnOneUser() {

        // arrange
        User u1 = new User("user1@home.nl");
        u1.setLastName("lastName");
        entityManager.persist(u1);
        entityManager.flush();

        // act
        User u2 = userRepository.findByEmail("user1@home.nl");

        // assert
        assertThat(u2).isNotNull();
        assertThat(u2.getLastName()).isEqualTo("lastName");

    }

    @Test
    public void whenFindByExistingLastNames_thenReturnMultipleUsers() {

        // arrange
        User u1 = new User("user1@home.nl");
        u1.setLastName("same");
        User u2 = new User("user2@home.nl");
        u2.setLastName("same");
        entityManager.persist(u1);
        entityManager.persist(u2);
        entityManager.flush();

        // act
        List<User> usrs = userRepository.findByLastName("same");

        // assert
        assertThat(usrs.size()).isEqualTo(2);
        assertThat(usrs.get(0).getEmail()).isEqualTo("user1@home.nl");
        assertThat(usrs.get(0).getLastName()).isEqualTo("same");
        assertThat(usrs.get(1).getEmail()).isEqualTo("user2@home.nl");
        assertThat(usrs.get(1).getLastName()).isEqualTo("same");

    }

    @Test
    public void whenFindByNotExistingEmail_thenReturnNull() {

        // act
        User u1 = userRepository.findByEmail("user1@home.nl");

        // assert
        assertThat(u1).isNull();

    }

    @Test
    public void whenFindByNotExistingLatName_thenReturnEmptyList() {

        // act
        List<User> usrs = userRepository.findByLastName("same");

        // assert
        assertThat(usrs.size()).isEqualTo(0);

    }

}
