package com.example.java6.restController;

import com.example.java6.entity.OrderDetail;
import com.example.java6.service.OrderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/details")
public class OrderDetailRestController {
    @Autowired
    private OrderDetailsService orderDetailService;

    @GetMapping()
    public List<OrderDetail> getByOrder(@RequestParam Integer id) {
        return orderDetailService.findByOrder(id);
    }

    @GetMapping("/report")
    public List<OrderDetail> getReport() {
        return orderDetailService.getReport();
    }
}
