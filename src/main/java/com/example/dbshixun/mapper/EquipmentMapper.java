package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EquipmentMapper {
    List<Equipment> equipmentList();
    void addEquipment(Equipment equipment);
    void deleteEquipment(int id);
    void updateEquipment(Equipment equipment);
    Equipment getEquipment(int id);

}
