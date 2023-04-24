package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Employee;
import com.example.dbshixun.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @ClassName EmployeeController
 * @author cancet
 * @Date 2023/4/14
 * @Description 员工表的控制层
 */
@RestController
@RequestMapping("/employee")
@Tag(name="EmployeeController",description = "员工表的控制层")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping ("/employees")
    @Operation(summary = "获取员工列表",description = "返回所有员工的信息")
    public List<Employee> employees(){
        return employeeService.employeeList();
    }

    @GetMapping("/getEmployee/{id}")
    @Operation(summary = "查询员工",description = "返回单个员工信息")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @PutMapping("/updateEmployee")
    @Operation(summary = "更新员工信息",description = "修改该员工的信息")
    public void updateEmployee(Employee employee){
       employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    @Operation(summary = "删除员工",description = "删除该员工的信息")
    public void deleteEmplotee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/getAttendanceRecords/{id}")
    @Operation(summary = "查询出勤记录",description = "返回单个员工的出勤记录")
    public String getAttendanceRecord(@PathVariable int id){
        return employeeService.getAttendanceRecord(id);
    }

    @GetMapping("/getTrainingRecords/{id}")
    @Operation(summary = "查询培训记录",description = "返回单个员工的培训记录")
    public String  getTrainingRecords(@PathVariable int id){
        return employeeService.getTrainingRecords(id);
    }

    @PostMapping("/addTraining/{id}")
    @Operation(summary = "安排培训",description = "给该id员工增加培训记录")
    public void addTraining(@PathVariable int id ,String training){
        Employee employee= employeeService.getEmployee(id);
        String beforeTraining = employee.getTrainingRecords();
        beforeTraining+=" "+training;
        employee.setTrainingRecords(beforeTraining);
        updateEmployee(employee);
    }

    @PostMapping("/addAttendance/{id}")
    @Operation(summary = "出勤打卡",description = "给该员工增加今日的打开记录")
    public void addAttendacnce(@PathVariable int id){
        Employee employee=employeeService.getEmployee(id);
        Date date=new Date();
        employee.setAttendanceRecords(employee.getAttendanceRecords() + date.toString());
        updateEmployee(employee);
    }

    @PostMapping("/addEmployee")
    @Operation(summary = "添加员工",description = "添加一个员工")
    public String addEmployee(Employee employee){
        try{
            employeeService.addEmployee(employee);
            return "201";
        }catch (Exception e){
            e.printStackTrace();
            return "400";
        }
    }
}
