package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "店铺实体类")
public class Store {
    private int storeId;
    private String storeName;
    private String location;
    @Schema(description = "租赁合同")
    private String leaseContract;
    @Schema(description = "物业管理")
    private String propertyManagement;

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLeaseContract() {
        return leaseContract;
    }

    public void setLeaseContract(String leaseContract) {
        this.leaseContract = leaseContract;
    }

    public String getPropertyManagement() {
        return propertyManagement;
    }

    public void setPropertyManagement(String propertyManagement) {
        this.propertyManagement = propertyManagement;
    }
}
