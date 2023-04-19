package com.example.dbshixun.service;

import com.example.dbshixun.mapper.EquipmentMapper;
import com.example.dbshixun.pojo.Equipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    public List<Equipment> equipmentList(){
        return equipmentMapper.equipmentList();
    }
    public Equipment getEquipment(int id){
        return equipmentMapper.getEquipment(id);
    }
    public void addEquipment(Equipment equipment){
        equipmentMapper.addEquipment(equipment);
    }
    public void deleteEquipment(int id){
        equipmentMapper.deleteEquipment(id);
    }
    public void updateEquipment(Equipment equipment){
        equipmentMapper.updateEquipment(equipment);
    }
}
