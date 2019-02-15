package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {

    Optional<Account> findByUser_Login(String login);
}
