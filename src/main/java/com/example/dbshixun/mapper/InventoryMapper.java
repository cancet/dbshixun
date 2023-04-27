package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Inventory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface InventoryMapper {
    List<Inventory>inventories();
    Inventory getInventory(int productId);
    void addInventory(Inventory inventory);
    void deleteInventory(int productId);
    void updateInventory(Inventory inventory);
}
