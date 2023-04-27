package com.example.dbshixun.service;

import com.example.dbshixun.mapper.InventoryMapper;
import com.example.dbshixun.pojo.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;
    public List<Inventory>inventories(){
        return inventoryMapper.inventories();
    }
    public Inventory getInventory(int productId){
        return inventoryMapper.getInventory(productId);
    }
    public void addInventory(Inventory inventory){
        inventoryMapper.addInventory(inventory);
    }
    public void deleteInventory(int productId){
        inventoryMapper.deleteInventory(productId);
    }
    public void updateInventory(Inventory inventory){
        inventoryMapper.updateInventory(inventory);
    }
}
