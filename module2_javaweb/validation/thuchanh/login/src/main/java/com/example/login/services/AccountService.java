package com.example.login.services;

import com.example.login.models.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccount();
    Account findAccountById(Long id);
    void removeAccountById(Long id);
    void saveAccount(Account account);
}
