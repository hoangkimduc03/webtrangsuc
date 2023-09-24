package com.example.java6.repository;

import com.example.java6.entity.Order;
import com.example.java6.entity.OrderDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderdetailDAO extends JpaRepository<OrderDetail,Long> {
    Page<OrderDetail> findOrderDetailByOrder(Order order, Pageable pageable);

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
