package com.example.java6.restController;

import com.example.java6.entity.Role;
import com.example.java6.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
    @Autowired
    private RolesService roleService;

    @GetMapping
    public List<Role> getAll() {
        return roleService.findAll();
    }
}
