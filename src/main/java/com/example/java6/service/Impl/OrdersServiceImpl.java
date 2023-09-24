package com.example.java6.service.Impl;

import com.example.java6.entity.Order;
import com.example.java6.entity.OrderDetail;
import com.example.java6.entity.OrderMap;
import com.example.java6.repository.OrderdetailDAO;
import com.example.java6.repository.OrdersDAO;
import com.example.java6.service.OrdersService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdersServiceImpl implements OrdersService {


    @Autowired
    private OrdersDAO ordersDAO;
    @Autowired
    private OrderdetailDAO orderdetailDAO;

//    @Autowired


    RestTemplate rest = new RestTemplate();

    String url = "https://java6-ph28107-default-rtdb.firebaseio.com/orders.json";

    public String getUrl(String key) {
        return url.replace(".json", "/" + key + ".json");
    }

    public OrderMap findAllRest() {
        return rest.getForObject(url, OrderMap.class);
    }

    public OrderMap findByKey(String key) {
        return rest.getForObject(getUrl(key + "/"), OrderMap.class);
    }

    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        ordersDAO.save(order);

        com.fasterxml.jackson.core.type.TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> details = mapper.convertValue(orderData.get("orderDetails"), type).
                stream().peek(d -> d.setOrder(order))
                .collect(Collectors.toList());
        orderdetailDAO.saveAll(details);
        return order;
    }

    public Order update(String key, Order data) {
        HttpEntity<Order> entity = new HttpEntity<>(data);
        rest.put(getUrl(key + "/"), entity);
        return data;
    }

    public void delete(String key) {
        rest.delete(getUrl(key) + "/");
    }

    public Page<Order> getAll(Pageable pageable) {
        return ordersDAO.findAll(pageable);
    }

    @Override
    public Order findById(Long id) {
        return ordersDAO.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return ordersDAO.findByUsername(username);
    }

    @Override
    public List<Order> findAll() {
        return ordersDAO.findAll();
    }
}
