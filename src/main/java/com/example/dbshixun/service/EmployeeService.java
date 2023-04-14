package com.example.dbshixun.service;

import com.example.dbshixun.mapper.EmployeeMapper;
import com.example.dbshixun.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> employeeList(){
        return  employeeMapper.employeeList();
    }

    public Employee getEmployee(int id){
        return employeeMapper.getEmployee(id);
    }

    public void updateEmployee(Employee employee){
        employeeMapper.updateEmployee(employee);
    }
    public void deleteEmployee(int id){
        employeeMapper.deleteEmployee(id);
    }
    public String getAttendanceRecord(int id){
        return employeeMapper.getAttendanceRecords(id);
    }
    public String getTrainingRecords(int id){
        return employeeMapper.getTrainingRecords(id);
    }
}
