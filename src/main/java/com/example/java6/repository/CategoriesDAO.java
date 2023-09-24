package com.example.java6.repository;

import com.example.java6.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriesDAO extends JpaRepository<Category,String> {
    Category findAllById(String id);
}
