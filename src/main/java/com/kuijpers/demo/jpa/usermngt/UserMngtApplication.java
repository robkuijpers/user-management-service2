package com.kuijpers.demo.jpa.usermngt;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.entity.Profile;
import com.kuijpers.demo.jpa.usermngt.entity.User;
import com.kuijpers.demo.jpa.usermngt.service.AccountService;
import com.kuijpers.demo.jpa.usermngt.service.ProfileService;
import com.kuijpers.demo.jpa.usermngt.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Locale;

@SpringBootApplication
public class UserMngtApplication {

    private static final Logger log = LoggerFactory.getLogger(UserMngtApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(UserMngtApplication.class, args);

    }

}
