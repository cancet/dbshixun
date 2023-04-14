package com.example.dbshixun.service;

import com.example.dbshixun.mapper.CustomerMapper;
import com.example.dbshixun.pojo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    public List<Customer>customerList(){
        return customerMapper.customerList();
    }
     public void addCustomer(Customer customer){
        customerMapper.addCustomer(customer);
     }
     public void deleteCustomer(int id){
        customerMapper.deleteCustomer(id);
     }
     public Customer getCustomer(int id){
        return customerMapper.getCustomer(id);
     }
     public String getOrderHistory(int id){
        return customerMapper.getOrderHistory(id);
     }
     public String getConsumptionHabits(int id){
        return customerMapper.getConsumptionHabits(id);
     }
}
