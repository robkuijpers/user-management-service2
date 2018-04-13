package com.kuijpers.demo.jpa.usermngt.repository;

import com.kuijpers.demo.jpa.usermngt.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByUserName(String userName);

}
