package com.kuijpers.demo.jpa.usermngt.entity;

import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Don't test simple getters and setters.
 */
public class UserTest {

    protected static Date date;

    @BeforeClass
    public static void setup() {
        LocalDate localDate = LocalDate.parse("2020-01-01");
        AccountTest.date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    @Test
    public void toStringTest() {

        // arrange
        User u = new User("me@home.nl");
        u.setLastName("123");
        u.setFirstName("456");
        u.setStreet("str1");
        u.setCity("789");
        u.setCountry("NL");
        u.setPhone("06");
        u.setPostalCode("1221AA");
        u.setDateOfBirth(UserTest.date);

        // act + assert
        assertEquals("User{id=null, email='me@home.nl', firstName='456', lastName='123', phone='06', dateOfBirth=null, street='str1', postalCode='1221AA', city='789', country='NL'}", u.toString());

    }

}