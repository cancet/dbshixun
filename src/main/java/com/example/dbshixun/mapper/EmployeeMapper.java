package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface EmployeeMapper {
    List<Employee>employeeList();
    Employee getEmployee(int id);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    String getAttendanceRecords(int id);
    String getTrainingRecords(int id);
}
