package com.example.Website_Selling_Shoes_Men_Sport.service;

import com.example.Website_Selling_Shoes_Men_Sport.entity.Account;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    public List<Account> findAll();
    public Account save(Account account);
    Account update(Account account);
    public void deleteById(UUID id);
    Account findAccountByUsername(String users);
    public Account getById(UUID id);

    Account findByUser(String users);

    Account searchByUsername(String username, String password);
}
