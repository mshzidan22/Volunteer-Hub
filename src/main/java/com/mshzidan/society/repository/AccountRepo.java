package com.mshzidan.society.repository;

import com.mshzidan.society.entites.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
    public Optional<Account> getByUsername(String username);
}
