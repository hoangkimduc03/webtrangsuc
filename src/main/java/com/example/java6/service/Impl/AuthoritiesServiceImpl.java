package com.example.java6.service.Impl;

import com.example.java6.entity.Account;
import com.example.java6.entity.Authority;
import com.example.java6.repository.AccountDAO;
import com.example.java6.repository.AuthoritiesDAO;
import com.example.java6.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoritiesServiceImpl implements AuthoritiesService {

    @Autowired
    private AuthoritiesDAO authoritiesDAO;
    @Autowired
    private AccountDAO accountDAO;

    @Override
    public List<Authority> findAll() {
        return authoritiesDAO.findAll();
    }

    @Override
    public Authority create(Authority auth) {
        return authoritiesDAO.save(auth);
    }

    @Override
    public void delete(Integer id) {
        authoritiesDAO.deleteById(id);
    }

    @Override
    public List<Authority> findAuthoritiesOfAdministrators() {
        List<Account> accounts = accountDAO.getAdministrators();
        return authoritiesDAO.authoritiesOf(accounts);
    }

    @Override
    public List<Authority> getOneByRole(String username) {
        return authoritiesDAO.getOneByRole(username);
    }

    @Override
    public void deleteByUsername(String username) {
        authoritiesDAO.deleteByUserName(username);
    }
}
