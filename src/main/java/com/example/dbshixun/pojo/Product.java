package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "产品实体类")
public class Product {
    private int productId;
    private String productName;
    private String productType;
    private float price;
    @Schema(description = "销售额")
    private int salesVolume;
}
