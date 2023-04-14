package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Employee;
import com.example.dbshixun.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/employeeList")
    public List<Employee> employeeList(){
        return employeeService.employeeList();
    }

    @RequestMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable int id){
        return employeeService.getEmployee(id);
    }

    @RequestMapping("/updateEmployee")
    public void updateEmployee(Employee employee){
       employeeService.updateEmployee(employee);
    }

    @RequestMapping("/deleteEmployee/{id}")
    public void deleteEmplotee(@PathVariable int id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/getAttendanceRecords/{id}")
    public String getAttendanceRecord(@PathVariable int id){
        return employeeService.getAttendanceRecord(id);
    }

    @GetMapping("/getTrainingRecords/{id}")
    public String  getTrainingRecords(@PathVariable int id){
        return employeeService.getTrainingRecords(id);
    }

    @RequestMapping("/addTraining/{id}")
    public void addTraining(@PathVariable int id ,String training){
        Employee employee= employeeService.getEmployee(id);
        String beforeTraining = employee.getTrainingRecords();
        beforeTraining+=" "+training;
        employee.setTrainingRecords(beforeTraining);
        updateEmployee(employee);
    }

    @RequestMapping("/addAttendance/{id}")
    public void addAttendacnce(@PathVariable int id){
        Employee employee=employeeService.getEmployee(id);
        Date date=new Date();
        employee.setAttendanceRecords(employee.getAttendanceRecords() + date.toString());
        updateEmployee(employee);
    }
}
