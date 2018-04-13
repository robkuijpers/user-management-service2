package com.kuijpers.demo.jpa.usermngt.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Locale;

@Entity
public class Profile {

    private static final Logger log = LoggerFactory.getLogger(Profile.class);

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Locale prefLanguage;

    /**
     *
     */
    public Profile() {

    }

    /**
     *
     */
    public Profile(Locale prefLanguage) {
        this.prefLanguage = prefLanguage;

    }

    public Long getId() {
        return id;
    }

    public Locale getPrefLanguage() {
        return prefLanguage;
    }

    public void setPrefLanguage(Locale prefLanguage) {
        this.prefLanguage = prefLanguage;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", prefLanguage='" + prefLanguage + '\'' +
                '}';
    }
}
