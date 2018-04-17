package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.User;
import com.kuijpers.demo.jpa.usermngt.repository.UserRepository;
import org.junit.Before;
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

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() {

        // Setup the mock.
        User u = new User("user@home.nl");
        u.setLastName("lastName");
        u.setFirstName("firstName");

        Mockito.when(userRepository.findByEmail(u.getEmail())).thenReturn(u);
    }

    @TestConfiguration
    static class UserServiceImplTestContextConfiguration {

        @Bean
        public UserService userService() {
            return new UserServiceImpl();
        }

    }

    @Test
    public void whenExistingUserName_thenAccountShouldBeFound() {

        String email = "user@home.nl";

        User u1 = userService.findByEmail(email);

        assertThat(u1.getEmail()).isEqualTo(email);

    }

}
