package com.example.Website_Selling_Shoes_Men_Sport.repository;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AccountRepos extends JpaRepository<Account, UUID> {
    @Query("Select p from Account p where p.username =?1 and p.password=?2")
    Account
    searchByAccount(String username, String password);

    @Query("Select p from Account p where p.username =?1")
    Account
    findByUser(String users);
}
