package com.example.java6.Controller;


import com.example.java6.entity.Order;
import com.example.java6.entity.OrderDetail;
import com.example.java6.service.OrderDetailsService;
import com.example.java6.service.OrdersService;
import com.example.java6.service.ProductsService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/cart")
public class RestCartController {
    private Order order = new Order();
    private Page<OrderDetail> detailByOrder;

    @Autowired
    private OrdersService ordersService;
    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private ProductsService productsService;

    @RequestMapping("/home")
    public String getCart(Model model) {
        Pageable pageable = PageRequest.of(0, 9);
//        detailByOrder = orderDetailsService.findOrderDetailByOrder();
        model.addAttribute("main", "cart");
        return "main";
    }

    @RequestMapping("/addCart/{id}")
    public String addCart(Model model, @PathVariable Integer id) {
        Pageable pageable = PageRequest.of(0, 9);
//        detailByOrder = orderDetailsService.findOrderDetailByOrder();
        return "cart";
    }

    @GetMapping("/checkout")
    public String checkOut(Model model) {
        Date date = new Date();
        model.addAttribute("date", date);
        model.addAttribute("main", "checkout");
        return "main";
    }
}
