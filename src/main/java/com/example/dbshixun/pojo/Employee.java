package com.example.dbshixun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private int employeeId;
    private String name;
    private double salary;
    //考勤记录
    private String attendanceRecords;
    private String trainingRecords;
}
