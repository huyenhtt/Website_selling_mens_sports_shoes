package com.example.Website_Selling_Shoes_Men_Sport.service.impl;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;
import com.example.Website_Selling_Shoes_Men_Sport.repository.AccountRepos;
import com.example.Website_Selling_Shoes_Men_Sport.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepos accountRepos;

    @Override
    public List<Account> findAll() {
        return accountRepos.findAll();
    }

    @Override
    public void save(Account account) {
        accountRepos.save(account);
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public Account getById(UUID id) {
        return null;
    }

    @Override
    public Account findByUser(String users) {
        return null;
    }

    @Override
    public Account searchByUsername(String username, String password) {
        return null;
    }
}
