package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Equipment;
import com.example.dbshixun.service.EquipmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @ClassName EquipmentController
 * @author cancet
 * @Date 2023/4/19
 * @Description 设备表的控制层
 */
@RestController
@RequestMapping("/equipment")
@Tag(name = "EquipmentController",description = "设备表的控制层")
public class EquipmentController {
    @Autowired
    private EquipmentService equipmentService;

    @GetMapping("/equipments")
    @Operation(summary = "设备列表",description = "返回设备列表")
    public List<Equipment>equipmentList() {
        return equipmentService.equipmentList();
    }

    @GetMapping("/getEquipment/{id}")
    @Operation(summary = "查询设备",description = "根据id返回单个设备信息")
    public Equipment getEquipment(@PathVariable int id){
        return equipmentService.getEquipment(id);
    }

    @PostMapping("/addEquipment")
    @Operation(summary = "添加设备",description = "向表里增加一个设备")
    public String addEquipment(Equipment equipment){
        try{
            equipmentService.addEquipment(equipment);
            return "201";
        }catch (Exception e){
            e.printStackTrace();
            return "404";
        }
    }
    @DeleteMapping("/deleteEquipment/{id}")
    @Operation(summary = "删除设备",description = "根据所给id删除设备")
    public String deleteEquipment(@PathVariable int id){
        try{
            equipmentService.deleteEquipment(id);
            return "200";
        }catch (Exception e){
            e.printStackTrace();
            return "404";
        }
    }
    @PutMapping("/updateEquipment/{id}")
    @Operation(summary = "更新设备",description = "根据所给id,跟新设备信息")
    public String updateEquipment(@PathVariable int id,Equipment equipment){
        try{
            Equipment equipment1 =equipmentService.getEquipment(id);
            if(equipment1!=null){
                equipmentService.updateEquipment(equipment);
                return "200";
            }else{
                return "404";
            }
        }catch (Exception e){
            e.printStackTrace();
            return "500";
        }
    }
}

