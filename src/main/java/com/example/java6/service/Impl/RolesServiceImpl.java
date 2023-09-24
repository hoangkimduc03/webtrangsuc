package com.example.java6.service.Impl;

import com.example.java6.entity.Role;
import com.example.java6.repository.RolesDAO;
import com.example.java6.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesDAO rolesDAO;

    public List<Role> getAll(){
        return rolesDAO.findAll();
    }


    @Override
    public List<Role> findAll() {
        return getAll();
    }
}
