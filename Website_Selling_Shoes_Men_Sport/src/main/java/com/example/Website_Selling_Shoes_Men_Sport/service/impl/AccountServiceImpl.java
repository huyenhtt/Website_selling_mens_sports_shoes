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
    public Account save(Account account) {
       return accountRepos.save(account);
    }

    @Override
    public Account update(Account tk) {
        return accountRepos.save(tk);

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
    public Account findAccountByUsername(String users) {
        return accountRepos.findAccountByUsername(users);
    }

    @Override
    public Account searchByUsername(String username, String password) {
        return null;
    }
}
