package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Equipment;
import com.example.dbshixun.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/equipment")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @RequestMapping("/equipmentList")
    public List<Equipment>equipmentList() {
        return equipmentService.equipmentList();
    }

    @GetMapping("/getEquipment/{id}")
    public Equipment getEquipment(@PathVariable int id){
        return equipmentService.getEquipment(id);
    }

    @RequestMapping("/addEquipment")
    public String addEquipment(Equipment equipment){
        try{
            equipmentService.addEquipment(equipment);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    @GetMapping("/deleteEquipment/{id}")
    public String deleteEquipment(@PathVariable int id){
        try{
            equipmentService.deleteEquipment(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
    @RequestMapping("/updateEquipment")
    public String updateEquipment(@PathVariable int id,Equipment equipment){
        try{
            Equipment equipment1 =equipmentService.getEquipment(id);
            if(equipment1!=null){
                equipmentService.updateEquipment(equipment);
                return "success";
            }else{
                return "equipment not exists";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "error";
        }
    }
}

