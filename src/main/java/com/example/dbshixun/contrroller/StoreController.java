package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Store;
import com.example.dbshixun.service.StoreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName EmployeeController
 * @author cancet
 * @Date 2023/4/24
 * @Description 商店表的控制层
 */
@RestController
@RequestMapping("/store")
@Tag(name = "StoreController", description = "商店表的控制层")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping("/stores")
    @Operation(summary = "商店列表",description = "返回所有商店信息")
    public List<Store> stores(){
        return storeService.stores();
    }

    @GetMapping("/getStore/{id}")
    @Operation(summary = "搜索商店",description = "返回搜索商店信息")
    public Store getStore(@PathVariable int id){
        return storeService.getStore(id);
    }
    @PostMapping("/addStore")
    @Operation(summary = "添加商店",description = "向表中添加一个新的商店信息")
    public String addStore(@RequestBody Store store){
        if (storeService.getStore(store.getStoreId())!=null){
            try{
                storeService.addStore(store);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }else {
            System.out.println("商店已存在");
            return "400";
        }
    }
    @DeleteMapping("/deleteStore/{id}")
    @Operation(summary = "删除商店",description = "删除表中的一个商店信息")
    public String deleteStore(@PathVariable int id){
        if(storeService.getStore(id)!=null){
            storeService.deleteStore(id);
            return "200";
        }else {
            System.out.println("商店不存在");
            return "404";
        }
    }
    @PutMapping("/updateStore")
    @Operation(summary = "修改商店信息",description = "修改商店的信息,商店的id不变")
    public String updateStore(@RequestBody Store store){
        if(storeService.getStore(store.getStoreId())==null){
            return "404";
        }else {
            try{
                storeService.updateStore(store);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }
    }
}
