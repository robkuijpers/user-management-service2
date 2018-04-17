package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.Profile;
import com.kuijpers.demo.jpa.usermngt.entity.User;
import com.kuijpers.demo.jpa.usermngt.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    /**
     *
     */
    public ProfileServiceImpl() {

    }

    /**
     * @return
     */
    public List<Profile> findAll() {

        return this.profileRepository.findAll();

    }

    /**
     * @param id
     * @return
     */
    public Profile findById(final Long id) {

        Optional<Profile> val = this.profileRepository.findById(id);

        if (val.isPresent()) {
            return val.get();
        } else {
            return null;
        }
    }

    /**
     * @param profile
     * @return
     */
    public Profile save(final Profile profile) {

        return this.profileRepository.save(profile);

    }

    /**
     * @param profile
     */
    public void delete(final Profile profile) {

        this.profileRepository.delete(profile);

    }

}
