package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Customer;
import com.example.dbshixun.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/**
 * @ClassName CustomerController
 * @author cancet
 * @Date 2023/4/14
 * @Description 顾客表的控制层
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customerList")
    public List<Customer>customerList(){
        return customerService.customerList();
    }
    @RequestMapping("/addCustomer")
    public String addCustomer(Customer customer) {
        try {
            customerService.addCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id){
        try{
            customerService.deleteCustomer(id);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
        return "success";
    }

    @RequestMapping("/getOrderHistory/{id}")
    public String getOrderHistory(@PathVariable int id){
        try{
            return customerService.getOrderHistory(id);
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/getCustomer/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerService.getCustomer(id);
    }
    @RequestMapping("/getConsumptionHabits/{id}")
    public String getConsumptionHabits(@PathVariable int id){
        return customerService.getConsumptionHabits(id);
    }
}
