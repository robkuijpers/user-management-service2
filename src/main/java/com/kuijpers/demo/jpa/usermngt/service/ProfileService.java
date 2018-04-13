package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Profile;

import java.util.List;

public interface ProfileService {

    public List<Profile> findAll();

    public Profile save(final Profile profile);

    public void delete(final Profile profile);

}
