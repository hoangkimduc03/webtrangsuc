package com.example.java6.repository;

import com.example.java6.entity.Category;
import com.example.java6.entity.OrderDetail;
import com.example.java6.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductsDAO extends JpaRepository<Product, Integer> {
    Page<Product> findAllByCategory(Category category, Pageable pageable);

    Product getProductById(Integer id);
    List<Product> getProductsByCategory(Category cagtegoryid);

    @Query("SELECT p FROM Product p WHERE p.category.id=?1")
    List<Product> findByCategoryId(String cid);


    @Query("SELECT od FROM OrderDetail od WHERE od.order.id = ?1")
    List<OrderDetail> findByOrder(Integer order);

    @Query("SELECT SUM(od.quantity) FROM OrderDetail od WHERE od.order.id = ?1")
    Integer totalItem(Integer order);

    @Query("SELECT SUM(od.price * od.quantity) FROM OrderDetail od WHERE od.order.id = ?1")
    Double totalPrice(Integer id);

    @Query(value = "SELECT o.Product_id, p.name, SUM(o.Quantity), SUM(o.price) FROM Order_details o "
            + "INNER JOIN Products p "
            + "ON o.Product_id = p.Id "
            + "GROUP BY Product_id, p.Name, o.Quantity", nativeQuery = true)
    List<OrderDetail> getReport();
}
