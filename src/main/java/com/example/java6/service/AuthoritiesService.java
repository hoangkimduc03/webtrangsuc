package com.example.java6.service;

import com.example.java6.entity.Authority;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthoritiesService {


    public List<Authority> findAll();

    public Authority create(Authority auth);

    public void delete(Integer id);

    public List<Authority> findAuthoritiesOfAdministrators();

    public List<Authority> getOneByRole(String username);

    public void deleteByUsername(String username);
}
