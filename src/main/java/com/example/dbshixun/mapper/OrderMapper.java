package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface OrderMapper {
    List<Order> orders();
    Order getOrder(int orderId);
    void addOrder(Order order);
    void deleteOrder(int orderId);
    void updateOrder(Order order);
}
