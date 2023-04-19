package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Product;
import com.example.dbshixun.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getMenu")
    public List<Product> getMenu(){
        return productService.getMenu();
    }
    @RequestMapping("/getSales")
    public List<Product>getSales(){
        return productService.getSales();
    }
    @RequestMapping("/productList")
    public List<Product>productList(){
        return productService.productList();
    }
    @PostMapping("/addProduct")
    public String addProduct(Product product){
        try{
            productService.addProduct(product);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    @GetMapping("/addSales/{id}")
    public void addSales(@PathVariable int id){
        productService.addSales(id);
    }

    @RequestMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @RequestMapping("/updatePrice/{id}+{price}")
    public void updatePrice(@PathVariable int id,@PathVariable float price){
        productService.updatePrice(id,price);
    }
}
