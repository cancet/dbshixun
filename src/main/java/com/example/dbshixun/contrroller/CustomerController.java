package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Customer;
import com.example.dbshixun.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @ClassName CustomerController
 * @author cancet
 * @Date 2023/4/14
 * @Description 顾客表的控制层
 */
@RestController
@RequestMapping("/customer")
@Tag(name = "CustomerController",
        description = "顾客表的控制层")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/customerList")
    @Operation(summary = "获取客户表",
            description = "得到所有的客户信息")
    public List<Customer>customerList(){
        return customerService.customerList();
    }
    @PostMapping("/addCustomer")
    @Operation(summary = "增加客户",
            description = "增加单个客户，失败返回error，成功返回success")
    public String addCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return "400";
        }
        return "201";
    }

    @DeleteMapping("/deleteCustomer/{id}")
    @Operation(summary = "删除用户",
            description = "根据给出的id，删除用户")
    public String deleteCustomer(@PathVariable int id){
        try{
            customerService.deleteCustomer(id);
        }catch (Exception e){
            e.printStackTrace();
            return "400";
        }
        return "204";
    }

    @GetMapping("/getOrderHistory/{id}")
    @Operation(summary = "查询订单记录",
            description = "根据给出的id，查询该用户的订单记录")
    public String getOrderHistory(@PathVariable int id){
        try{
            return customerService.getOrderHistory(id);
        }catch (Exception e){
            e.printStackTrace();
            return "400";
        }
    }
    @GetMapping("/getCustomer/{id}")
    @Operation(summary = "返回单个客户",
            description = "根据所给客户id，查询单个用户信息")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }
    @GetMapping("/getConsumptionHabits/{id}")
    @Operation(summary = "查询喜好",description = "根据所给客户id")
    public String getConsumptionHabits(@PathVariable int id){
        return customerService.getConsumptionHabits(id);
    }
}
