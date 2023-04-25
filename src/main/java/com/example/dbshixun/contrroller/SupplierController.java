package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Supplier;
import com.example.dbshixun.service.SupplierService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName SupplierController
 * @author cancet
 * @Date 2023/4/25
 * @Description 供应商表的控制层
 */

@RestController
@RequestMapping("/supplier")
@Tag(name="SupplierController",description = "供应商表的控制层")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    @Operation(summary = "供应商列表",description = "返回所有供应商的信息")
    public List<Supplier>suppliers(){
        return supplierService.suppliers();
    }

    @GetMapping("/getSupplier/{id}")
    @Operation(summary = "查询供应商",description = "返回查询供应商的信息")
    public Supplier getSupplier(@PathVariable int id){
        return  supplierService.getSupplier(id);
    }

    @PostMapping("/addSupplier")
    @Operation(summary = "增加供应商",description = "添加一个新的供应商信息进入表中")
    public String addSupplier(@RequestBody Supplier supplier){
        if(supplierService.getSupplier(supplier.getSupplierId())!=null){
            return "400";
        }else{
            try{
                supplierService.addSupplier(supplier);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }
    }
    @DeleteMapping("/deleteSupplier/{id}")
    @Operation(summary = "删除供应商",description = "将表中对应的供应商信息删除")
    public String deleteSupplier(@PathVariable int id){
        if(supplierService.getSupplier(id)==null){
            System.out.println("供应商不存在");
            return "404";
        }else {
            supplierService.deleteSupplier(id);
            return "200";
        }

    }
}
