package com.example.dbshixun.service;

import com.example.dbshixun.mapper.OrderMapper;
import com.example.dbshixun.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    public List<Order>orders(){
        return orderMapper.orders();
    }
    public Order getOrder(int orderId){
        return orderMapper.getOrder(orderId);
    }
    public void addOrder(Order order){
        orderMapper.addOrder(order);
    }
    public void deleteOrder(int orderId){
        orderMapper.deleteOrder(orderId);
    }
    public void updateOrder(Order order){
        orderMapper.updateOrder(order);
    }
}
