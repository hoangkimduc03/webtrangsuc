package com.example.java6.repository;

import com.example.java6.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesDAO extends JpaRepository<Role,Long> {
}
