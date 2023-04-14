package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CustomerMapper {
    List<Customer> customerList();
    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    Customer getCustomer(int id);
    String getOrderHistory(int id);
    String getConsumptionHabits(int id);
}
