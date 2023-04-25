package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "供应商实体类")
public class Supplier {
    private int supplierId;
    private String supplierName;
    private int productId;
    private String productName;
    private double price;
    @Schema(description = "质量检测记录")
    private String qualityInspectionRecords;
}
