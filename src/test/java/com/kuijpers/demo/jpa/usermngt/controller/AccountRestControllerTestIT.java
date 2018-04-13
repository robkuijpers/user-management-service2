package com.kuijpers.demo.jpa.usermngt.controller;

import com.kuijpers.demo.jpa.usermngt.UserMngtApplication;
import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = {UserMngtApplication.class})
@AutoConfigureMockMvc                        // -> instantiate whole spring context.
//@WebMvcTest(AccountRestController.class)   // -> instantiate only web layer.
@ActiveProfiles({"it"})
public class AccountRestControllerTestIT {

    @Autowired
    protected TestRestTemplate testRestTemplate;  // not used yet

    @Autowired
    Environment env;                              // not used yet

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService accountService;

    @Test
    public void givenAccounts_whenGetAccounts_thenStatus200() throws Exception {

        // arrange
        Account acc1 = new Account("123", "456");
        Account acc2 = new Account("678", "901");
        List<Account> mockAccounts = Arrays.asList(acc1, acc2);

        Mockito.when(accountService.findAll()).thenReturn(mockAccounts);

        // act + assert
        mvc.perform(get("/api/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].userName", is("123")))
                .andExpect(jsonPath("$[0].password", is("456")))
                .andExpect(jsonPath("$[1].userName", is("678")))
                .andExpect(jsonPath("$[1].password", is("901")));

    }

}
