package com.kuijpers.demo.jpa.usermngt.service;

import com.kuijpers.demo.jpa.usermngt.entity.User;
import com.kuijpers.demo.jpa.usermngt.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @return
     */
    public List<User> findAll() {

        return this.userRepository.findAll();

    }

    /**
     * @param id
     * @return
     */
    public User findById(final Long id) {

        Optional<User> val = this.userRepository.findById(id);

        if (val.isPresent()) {
            return val.get();
        } else {
            return null;
        }
    }

    /**
     * @param email
     * @return
     */
    public User findByEmail(final String email) {

        return this.userRepository.findByEmail(email);

    }

    /**
     * @param lastName
     * @return
     */
    public List<User> findByLastName(final String lastName) {

        return this.userRepository.findByLastName(lastName);

    }

    /**
     * @param user
     * @return
     */
    public User save(final User user) {

        return this.userRepository.save(user);

    }

    /**
     * @param user
     */
    public void delete(final User user) {

        this.userRepository.delete(user);

    }
}
