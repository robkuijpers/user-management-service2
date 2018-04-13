package com.kuijpers.demo.jpa.usermngt.entity;

import org.junit.Test;

import java.util.Locale;

import static org.junit.Assert.assertEquals;

/**
 * Don't test simple getters and setters.
 */
public class ProfileTest {

    @Test
    public void toStringTest() {

        // arrange
        Profile p = new Profile(Locale.ENGLISH);

        // act + assert
        assertEquals("Profile{id=null, prefLanguage='en'}", p.toString());

    }
}
