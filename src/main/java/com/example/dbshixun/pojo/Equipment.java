package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "设备实体类")
public class Equipment {
    private int equipmentId;
    private String equipmentName;
    @Schema(description = "保养记录")
    private String maintenanceRecords;
    @Schema(description = "保养计划")
    private String maintenancePlan;

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getMaintenanceRecords() {
        return maintenanceRecords;
    }

    public void setMaintenanceRecords(String maintenanceRecords) {
        this.maintenanceRecords = maintenanceRecords;
    }

    public String getMaintenancePlan() {
        return maintenancePlan;
    }

    public void setMaintenancePlan(String maintenancePlan) {
        this.maintenancePlan = maintenancePlan;
    }
}
