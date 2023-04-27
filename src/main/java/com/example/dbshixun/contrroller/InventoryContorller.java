package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Employee;
import com.example.dbshixun.pojo.Inventory;
import com.example.dbshixun.service.InventoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName InventoryContorller
 * @author cancet
 * @Date 2023/4/27
 * @Description 库存表的控制层
 */
@RestController
@RequestMapping("/inventory")
@Tag(name = "InventoryContorller",description = "库存表的控制层")
public class InventoryContorller {
    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/inventories")
    @Operation(summary = "库存列表",description = "返回表中所有信息")
    public List<Inventory>inventories(){
        return inventoryService.inventories();
    }
    @GetMapping("/getInventory/{id}")
    @Operation(summary = "获取库存",description = "返回单个货物库存信息")
    public Inventory getInventory(@PathVariable int id){
        return inventoryService.getInventory(id);
    }
    @PostMapping("/addInventory")
    @Operation(summary = "添加库存",description = "新增一个原料库存信息")
    public String addInventory(@RequestBody Inventory inventory){
        if (inventoryService.getInventory(inventory.getProductId())!=null) {
            System.out.println("当前原料已存在");
            return "400";
        }else{
            try{
                inventoryService.addInventory(inventory);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }
    }
    @DeleteMapping("/deleteInventoey/{id}")
    @Operation(summary = "删除库存",description = "删除库存表当中的信息")
    public String deleteInventory(@PathVariable int id){
        if(inventoryService.getInventory(id)!=null){
            try{
                inventoryService.deleteInventory(id);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }else{
            System.out.println("原料不存在");
            return "404";
        }
    }
    @PutMapping("/updateInventory")
    @Operation(summary = "更新库存",description = "更新原料的库存信息")
    public String updateInventory(@RequestBody Inventory inventory){
        if (inventoryService.getInventory(inventory.getProductId())!=null){
            try{
                inventoryService.updateInventory(inventory);
                return "200";
            }catch (Exception e){
                e.printStackTrace();
                return "500";
            }
        }else {
            System.out.println("原料不存在");
            return "404";
        }
    }
}
