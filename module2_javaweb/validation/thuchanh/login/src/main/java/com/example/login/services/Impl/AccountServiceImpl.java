package com.example.login.services.Impl;

import com.example.login.models.Account;
import com.example.login.repositories.AccountRepository;
import com.example.login.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Override
    public List<Account> getAllAccount() {
        return accountRepository.findAll();
    }

    @Override
    public Account findAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void removeAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountRepository.save(account);
    }
}
