package com.example.java6.Controller;

import com.example.java6.entity.Category;
import com.example.java6.entity.Order;
import com.example.java6.entity.Product;
import com.example.java6.repository.AuthoritiesDAO;
import com.example.java6.service.AccountService;
import com.example.java6.service.CategoriesService;
import com.example.java6.service.OrdersService;
import com.example.java6.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class HomeController {
    private Page<Product> generalList;

    @Autowired
    private ProductsService productsService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CategoriesService categoriesService;

    @Autowired
    private OrdersService ordersService;

    @Autowired
    private AuthoritiesDAO authoritiesDAO;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String getall(Model model) {
        Sort sort = Sort.by(Sort.Direction.ASC, "name");
        Pageable pageable = PageRequest.of(0, 9, sort);
        generalList = productsService.getAll(pageable);
        System.out.println(generalList.get().collect(Collectors.toList()).get(0).getCategory().getId());
        model.addAttribute("products", generalList);
        System.out.println(categoriesService.getAll());
        int totalPages = generalList.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        List<Category> categories = categoriesService.getAll();
        model.addAttribute("categories", categories);
        for (int i = 0; i < totalPages; i++) {
            listPage.add(i);
        }
        model.addAttribute("pageNumber", listPage);
        model.addAttribute("main", "shop");
        return "main";
    }

    @GetMapping("/details/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Product product = productsService.getProductById(id);
        Category category = categoriesService.findAllById(product.getCategory().getId());
        List<Product> listLike = productsService.getProductsByCategory(category);
        System.out.println(product);
        model.addAttribute("productlike", listLike);
        model.addAttribute("product", product);
        model.addAttribute("main", "detail");
        return "main";
    }


    @GetMapping("/order/history/{page}")
    public String history(Model model, @PathVariable("page") int page) {
        Sort sort = Sort.by(Sort.Direction.ASC, "createDate");
        Pageable pageable = PageRequest.of(page, 5, sort);
        Page<Order> orders = ordersService.getAll(pageable);
        int totalPages = orders.getTotalPages();
        List<Integer> listPage = new ArrayList<>();
        int end = page + 5;
        if (end == totalPages || end < totalPages) {
            for (int i = page; i < end; i++) {
                listPage.add(i);
            }
            model.addAttribute("pageNumber", listPage);
            model.addAttribute("orders", orders);
            model.addAttribute("main", "history");
            return "main";
        } else {
            for (int i = page; i < totalPages - 1; i++) {
                listPage.add(i);
            }
            model.addAttribute("pageNumber", listPage);
            model.addAttribute("orders", orders);
            model.addAttribute("main", "history");
            return "main";
        }

    }
}
