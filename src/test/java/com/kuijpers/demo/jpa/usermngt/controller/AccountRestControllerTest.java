package com.kuijpers.demo.jpa.usermngt.controller;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import com.kuijpers.demo.jpa.usermngt.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountRestController.class)
public class AccountRestControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private AccountService accountService;

    // write test cases here
    @Test
    public void givenAccount_whenGetAllAccount_thenReturnJsonArray() throws Exception {

        // arrange
        Account acc = new Account("123", "456");

        List<Account> allAccounts = Arrays.asList(acc);

//        given some preconditions (Arrange)
//        when an action occurs (Act)
//        then verify the output (Assert)

        BDDMockito.given(accountService.findAll()).willReturn(allAccounts);
        // or use: Mockito.when(accountService.findAll()).thenReturn(allAccounts);

        // act + assert
        mvc.perform(get("/api/accounts")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].userName", is(acc.getUserName())))
                .andExpect(jsonPath("$[0].password", is(acc.getPassword())));


    }

}
