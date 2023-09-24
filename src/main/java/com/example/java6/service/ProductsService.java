package com.example.java6.service;

import com.example.java6.entity.Category;
import com.example.java6.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;

@Service
public interface ProductsService {
    Page<Product> getAll(Pageable pageable);

    Product save(Product product);
    List<Product> save(List<Product> listProducts);

    void delete(Product product);

    void delete(List<Product> listProducts);

    List<Product> getAll(Sort sort);

    Page<Product> getByCategory(Category CategoryId, Pageable pageable);

    File saveFile(MultipartFile file, String path);

    Product getProductById(Integer id);

    List<Product> getProductsByCategory(Category cagtegoryid);


    List<Product> findAll();

    Product findById(Integer id);

    List<Product> findByCategoryId(String cid);

    Product create(Product product);

    Product update(Product product);

    void delete(Integer id);

}
