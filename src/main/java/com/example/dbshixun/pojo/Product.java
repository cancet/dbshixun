package com.example.dbshixun.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private int productId;
    private String productName;
    private String productType;
    private float price;
    private int salesVolume;
}
