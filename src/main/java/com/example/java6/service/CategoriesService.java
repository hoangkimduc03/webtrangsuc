package com.example.java6.service;

import com.example.java6.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoriesService {

    List<Category> getAll();

    Category findAllById(String id);

    List<Category> findAll();

    Category findById(String id);

    Category create(Category category);

    Category update(Category category);

    void delete(String id);
}
