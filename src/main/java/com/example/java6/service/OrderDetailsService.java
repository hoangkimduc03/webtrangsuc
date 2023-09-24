package com.example.java6.service;

import com.example.java6.entity.Order;
import com.example.java6.entity.OrderDetail;
import com.example.java6.entity.OrderDetailMap;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public interface OrderDetailsService {
    Page<OrderDetail> findOrderDetailByOrder(Order order, Pageable pageable);

    RestTemplate rest = new RestTemplate();


    String getUrl(String key);

    OrderDetailMap findAllRest();

    OrderDetailMap findByKey(String key);

    String create(OrderDetail data);

    OrderDetail update(String key, OrderDetail data);

    void delete(String key);


    List<OrderDetail> findByOrder(Integer order);

    Integer totalItem(Integer order);

    Double totalPrice(Integer id);

    List<OrderDetail> getReport();
}
