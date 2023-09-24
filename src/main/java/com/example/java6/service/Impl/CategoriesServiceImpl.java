package com.example.java6.service.Impl;

import com.example.java6.entity.Category;
import com.example.java6.repository.CategoriesDAO;
import com.example.java6.service.CategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriesServiceImpl implements CategoriesService {
    @Autowired
    private CategoriesDAO categoriesDAO;

    @Override
    public List<Category> getAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public Category findAllById(String id) {
        return categoriesDAO.findAllById(id);
    }

    @Override
    public List<Category> findAll() {
        return categoriesDAO.findAll();
    }

    @Override
    public Category findById(String id) {
        return categoriesDAO.findById(id).get();
    }

    @Override
    public Category create(Category category) {
        return categoriesDAO.save(category);
    }

    @Override
    public Category update(Category category) {
        return categoriesDAO.save(category);
    }

    @Override
    public void delete(String id) {
        categoriesDAO.deleteById(id);
    }
}
