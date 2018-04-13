package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    List<User> findByLastName(String lastName);

}

