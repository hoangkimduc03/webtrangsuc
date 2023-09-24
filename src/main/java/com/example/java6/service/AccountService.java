package com.example.java6.service;


import com.example.java6.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface AccountService {
    Account findByUsername(String username);

    List<Account> getAll();


    public List<Account> findAll();
    public Account findById(String username);
    public List<Account> getAdministrators();
    public Account create(Account account);
    public Account update(Account account);
}
