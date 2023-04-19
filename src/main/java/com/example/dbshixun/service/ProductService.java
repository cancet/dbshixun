package com.example.dbshixun.service;

import com.example.dbshixun.mapper.ProductMapper;
import com.example.dbshixun.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductMapper productMapper;
    public List<Product>getMenu(){
        return productMapper.getMenu();
    }
    public List<Product>getSales(){
        return productMapper.getSales();
    }
    public List<Product>productList(){
        return productMapper.productList();
    }
    public void addProduct(Product product){
        productMapper.addProduct(product);
    }
    public void addSales(int id){
        productMapper.addSales(id);
    }
    public void deleteProduct(int id){
        productMapper.deleteProduct(id);
    }
    public void updatePrice(int id,float price){
        productMapper.updatePrice(id,price);
    }
}
