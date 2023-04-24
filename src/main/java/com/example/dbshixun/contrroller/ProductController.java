package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Product;
import com.example.dbshixun.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @ClassName ProductController
 * @author cancet
 * @Date 2023/4/19
 * @Description 商品表的控制层
 */
@RestController
@RequestMapping("/product")
@Tag(name="ProductController",description = "商品表的控制层")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getMenu")
    @Operation(summary = "获取菜单",description = "从表中返回商品名，id和价格")
    public List<Product> getMenu(){
        return productService.getMenu();
    }
    @GetMapping("/getSales")
    @Operation(summary = "获取销量",description = "从表中返回商品名，id和销量")
    public List<Product>getSales(){
        return productService.getSales();
    }
    @GetMapping("/products")
    @Operation(summary = "获取商品信息",description = "返回所有商品的信息")
    public List<Product>products(){
        return productService.productList();
    }
    @PostMapping("/addProduct")
    @Operation(summary = "增加商品",description = "向表中添加一个商品信息")
    public String addProduct(Product product){
        try{
            productService.addProduct(product);
            return "201";
        }catch (Exception e){
            e.printStackTrace();
            return "400";
        }
    }
    @GetMapping("/addSales/{id}")
    @Operation(summary = "增加销量",description = "使该商品在表中的销量数加1")
    public void addSales(@PathVariable int id){
        productService.addSales(id);
    }

    @DeleteMapping("/deleteProduct/{id}")
    @Operation(summary = "删除商品",description = "删除该商品信息")
    public void deleteProduct(@PathVariable int id){
        productService.deleteProduct(id);
    }

    @PutMapping("/updatePrice/{id}/{price}")
    @Operation(summary = "修改价格",description = "修改该商品的价格")
    public void updatePrice(@PathVariable int id,@PathVariable float price){
        productService.updatePrice(id,price);
    }
}
