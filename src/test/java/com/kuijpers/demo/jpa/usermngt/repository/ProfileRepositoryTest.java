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

import java.util.Locale;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * No tests.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProfileRepositoryTest {

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void whenFindByExistingId_thenReturnProfile() {

        // arrange
        Profile p1 = new Profile(Locale.ENGLISH);
        entityManager.persist(p1);
        entityManager.flush();

        // act
        Optional<Profile> p2  = profileRepository.findById(p1.getId());

        // assert
        assertThat(p2.get().getId()).isEqualTo(p1.getId());
        assertThat(p2.get().getPrefLanguage()).isEqualTo(Locale.ENGLISH);
    }

    @Test
    public void whenFindByNotExistingId_thenValueInOptionalIsNotPresent() {

        // arrange
        Profile p1 = new Profile(Locale.ENGLISH);
        entityManager.persist(p1);
        entityManager.flush();

        // act
        Optional<Profile> p2 = profileRepository.findById(new Long(123456));

        assertThat(p2.isPresent()).isFalse();
    }

}

