package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Order;
import com.example.dbshixun.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName OrderController
 * @author cancet
 * @Date 2023/4/26
 * @Description 订单表的控制层
 */
@RestController
@RequestMapping("/order")
@Tag(name = "OrderController",description = "订单表的控制层")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    @Operation(summary = "订单列表",description = "返回所有订单信息")
    public List<Order>orders(){
        return orderService.orders();
    }
    @GetMapping("/getOrder")
    @Operation(summary = "查询订单",description = "返回要寻找的订单信息")
    public Order getOrder(int orderId){
        return orderService.getOrder(orderId);
    }
    @PostMapping("/addOrder")
    @Operation(summary = "添加订单",description = "向表中添加一个新的订单信息")
    public String addOrder(Order order){
        if(orderService.getOrder(order.getOrderId())==null){
            try{
                orderService.addOrder(order);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }else {
            System.out.println("订单已存在");
            return "400";
        }
    }
    @DeleteMapping("/deleteOrder/{id}")
    @Operation(summary = "取消订单",description = "删除该订单信息")
    public String deleteOrder(@PathVariable int orderId) {
        if (orderService.getOrder(orderId) != null) {
            try {
                orderService.deleteOrder(orderId);
                return "200";
            } catch (Exception e) {
                e.printStackTrace();
                return "500";
            }

        } else {
            System.out.println("订单不存在");
            return "404";
        }
    }
    @PutMapping("/updateOrder")
    @Operation(summary = "修改订单",description = "修改订单信息")
    public String updateOrder(Order order){
        if(orderService.getOrder(order.getOrderId())!=null){
            try{
                orderService.updateOrder(order);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }else {
            System.out.println("订单不存在");
            return "404";
        }
    }
}
