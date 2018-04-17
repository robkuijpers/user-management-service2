package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.repository.ProfileRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ProfileServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @MockBean
    private ProfileRepository profileRepository;

    @Autowired
    private ProfileService profileService;

    @Before
    public void setUp() {

        // Setup the mock.

    }

    @Test
    public void whenExistingId_thenProfileShouldBeFound() {

    }

    @TestConfiguration
    static class ProfileServiceImplTestContextConfiguration {

        @Bean
        public ProfileService profileService() {
            return new ProfileServiceImpl();
        }

    }

}
