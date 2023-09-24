package com.example.java6.service;

import com.example.java6.entity.Order;
//import com.example.java6.entity.OrderMap;
import com.example.java6.entity.OrderMap;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface OrdersService {
    String getUrl(String key);

    OrderMap findAllRest();


    OrderMap findByKey(String key);

    Order create(JsonNode data);

    //
    Order update(String key, Order data);

    void delete(String key);

    Page<Order> getAll(Pageable pageable);

    Order findById(Long id);

    List<Order> findByUsername(String username);

    List<Order> findAll();
}
//
//
