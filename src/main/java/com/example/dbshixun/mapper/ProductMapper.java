package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProductMapper {
    List<Product> getMenu();
    List<Product> getSales();
    List<Product> productList();
    void addProduct(Product product);
    void addSales(int id);
    void deleteProduct(int id);
    void updatePrice(int id,float price);
}
