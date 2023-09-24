package com.example.java6.service.Impl;

import com.example.java6.entity.Account;
import com.example.java6.repository.AccountDAO;
import com.example.java6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ffffffffAccountServiceImpl implements AccountService {
    @Autowired
    private AccountDAO accountDAO;
    private PasswordEncoder passwordEncoder;

    public List<Account> findAll() {
        return accountDAO.findAll();
    }

    @Override
    public Account findById(String username) {
        return accountDAO.findByUsername(username);
    }

    @Override
    public List<Account> getAdministrators() {
        return accountDAO.getAdministrators();
    }

    @Override
    public Account create(Account account) {
        return accountDAO.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountDAO.save(account);
    }

    @Override
    public Account findByUsername(String username) {
        return accountDAO.findByUsername(username);
    }

    @Override
    public List<Account> getAll() {
        return accountDAO.findAll();
    }

    public Account save(Account account) {
        String encryptedPassword = passwordEncoder.encode(account.getPassword());
        account.setPassword(encryptedPassword);
        return accountDAO.save(account);
    }

    public static void main(String[] args) {
        System.out.println(new AccountServiceImpl().findByUsername("ALFKI"));
    }
}
