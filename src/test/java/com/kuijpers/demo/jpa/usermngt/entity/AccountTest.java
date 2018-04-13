package com.kuijpers.demo.jpa.usermngt.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Don't test simple getters and setters.
 */
public class AccountTest {

    protected static Date date;

    @BeforeClass
    public static void setup() {
        LocalDate localDate = LocalDate.parse("2020-01-01");
        AccountTest.date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Test
    public void toStringTest() {
        Account a = new Account("123", "456");
        a.setBlocked(false);
        a.setConfirmed(true);
        a.setConfirmCode("123");
        a.setConfirmDate(AccountTest.date);
        a.setCreationDate(AccountTest.date);
        a.setDeleted(false);
        a.setPassword("123");
        a.setUserName("123");
        a.setUser(new User("me@home.nl"));
        a.setProfile(new Profile(Locale.ENGLISH));

        // act + assert
        assertEquals("Account{id=null, userName='123', password='123', creationDate=Wed Jan 01 00:00:00 CET 2020, confirmed=true, confirmCode='123', confirmDate=Wed Jan 01 00:00:00 CET 2020, blocked=false, deleted=false}", a.toString());


    }

}
