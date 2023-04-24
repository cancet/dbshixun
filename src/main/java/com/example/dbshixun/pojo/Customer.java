package com.example.dbshixun.pojo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "Customer",description = "顾客实体类")
public class Customer {
    @Schema(nullable = false,description = "顾客id，在在数据库中充当主键")
    private int customerId;
    @Schema(description = "用户名")
    private String name;
    private String phone;
    private String email;
    //消费记录
    @Schema(description = "消费记录")
    private String orderHistory;
    //消费习惯
    @Schema(description = "消费习惯")
    private String consumptionHabits;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(String orderHistory) {
        this.orderHistory = orderHistory;
    }

    public String getConsumptionHabits() {
        return consumptionHabits;
    }

    public void setConsumptionHabits(String consumptionHabits) {
        this.consumptionHabits = consumptionHabits;
    }
}
