package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "员工实体类")
public class Employee {
    private int employeeId;
    private String name;
    private double salary;
    //考勤记录
    @Schema(description = "考勤记录")
    private String attendanceRecords;
    @Schema(description = "培训记录")
    private String trainingRecords;
}
