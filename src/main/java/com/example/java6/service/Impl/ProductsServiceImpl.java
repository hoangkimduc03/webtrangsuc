package com.example.java6.service.Impl;

import com.example.java6.entity.Category;
import com.example.java6.entity.Product;
import com.example.java6.repository.ProductsDAO;
import com.example.java6.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public class ProductsServiceImpl implements ProductsService {
    @Autowired
    private ProductsDAO productsDAO;

    public Page<Product> getAll(Pageable pageable) {
        return productsDAO.findAll(pageable);
    }

    @Override
    public Product save(Product product) {
        return productsDAO.save(product);
    }

    @Override
    public List<Product> save(List<Product> listProducts) {
        return productsDAO.saveAll(listProducts);
    }

    @Override
    public void delete(Product product) {
        productsDAO.delete(product);
    }

    @Override
    public void delete(List<Product> listProducts) {
        productsDAO.deleteAll(listProducts);
    }

    @Override
    public List<Product> getAll(Sort sort) {
        return productsDAO.findAll(sort);
    }

    @Override
    public Page<Product> getByCategory(Category CategoryId, Pageable pageable) {
        return productsDAO.findAllByCategory(CategoryId, pageable);
    }

    @Override
    public File saveFile(MultipartFile file, String path) {
        return new File(path);
    }

    @Override
    public Product getProductById(Integer id) {
        return productsDAO.getProductById(id);
    }

    @Override
    public List<Product> getProductsByCategory(Category cagtegory) {
        return productsDAO.getProductsByCategory(cagtegory);
    }

    @Override
    public List<Product> findAll() {
        return productsDAO.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productsDAO.getProductById(id);
    }

    @Override
    public List<Product> findByCategoryId(String cid) {
        return productsDAO.findByCategoryId(cid);
    }

    @Override
    public Product create(Product product) {
        return productsDAO.save(product);
    }

    @Override
    public Product update(Product product) {
        return productsDAO.save(product);
    }

    @Override
    public void delete(Integer id) {
        productsDAO.deleteById(id);
    }


}
