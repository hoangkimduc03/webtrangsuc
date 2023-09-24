package com.example.java6.service.Impl;

import com.example.java6.entity.Order;
import com.example.java6.entity.OrderDetail;
import com.example.java6.entity.OrderDetailMap;
import com.example.java6.repository.OrderdetailDAO;
import com.example.java6.service.OrderDetailsService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderDetailsServiceImpl implements OrderDetailsService {
    @Autowired
    private OrderdetailDAO orderdetailDAO;

    @Override
    public Page<OrderDetail> findOrderDetailByOrder(Order order, Pageable pageable) {
        return findOrderDetailByOrder(order, pageable);
    }

    RestTemplate rest = new RestTemplate();

    String url = "https://java6-ph28107-default-rtdb.firebaseio.com/orderDetails.json";

    public String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public OrderDetailMap findAllRest() {
        return rest.getForObject(url, OrderDetailMap.class);
    }

    public OrderDetailMap findByKey(String key) {
        return rest.getForObject(getUrl(key + "/"), OrderDetailMap.class);
    }

    public String create(OrderDetail data) {
        HttpEntity<OrderDetail> entity = new HttpEntity<>(data);
        JsonNode resp = rest.postForObject(url, entity, JsonNode.class);
        return resp.get("name").asText();
    }

    public OrderDetail update(String key, OrderDetail data) {
        HttpEntity<OrderDetail> entity = new HttpEntity<>(data);
        rest.put(getUrl(key + "/"), entity);
        return data;
    }

    public void delete(String key) {
        rest.delete(getUrl(key) + "/");
    }

    @Override
    public List<OrderDetail> findByOrder(Integer order) {
        return orderdetailDAO.findByOrder(order);
    }

    @Override
    public Integer totalItem(Integer order) {
        return orderdetailDAO.totalItem(order);
    }

    @Override
    public Double totalPrice(Integer id) {
        return orderdetailDAO.totalPrice(id);
    }

    @Override
    public List<OrderDetail> getReport() {
        return orderdetailDAO.getReport();
    }
}
