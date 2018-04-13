package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {

}

