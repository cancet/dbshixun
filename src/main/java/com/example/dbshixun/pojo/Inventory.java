package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "库存实体类")
public class Inventory {
    private int productId;
    private String productName;
    private int StockQuantity;
    @Schema(description = "购买记录")
    private String PurchaseRecords;
    @Schema(description = "损坏记录")
    private String DamageRecords;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getStockQuantity() {
        return StockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        StockQuantity = stockQuantity;
    }

    public String getPurchaseRecords() {
        return PurchaseRecords;
    }

    public void setPurchaseRecords(String purchaseRecords) {
        PurchaseRecords = purchaseRecords;
    }

    public String getDamageRecords() {
        return DamageRecords;
    }

    public void setDamageRecords(String damageRecords) {
        DamageRecords = damageRecords;
    }
}
