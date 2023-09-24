package com.example.java6.restController;

import com.example.java6.entity.Order;
import com.example.java6.service.OrdersService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    private OrdersService orderService;

    @PostMapping()
    public Order create(@RequestBody JsonNode orderData) {
        System.out.println("helle");
        return orderService.create(orderData);
    }

    @GetMapping()
    public List<Order> getAll() {
        return orderService.findAll();
    }
}
