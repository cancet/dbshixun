package com.example.dbshixun.mapper;

import com.example.dbshixun.pojo.Finance;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Mapper
@Repository
public interface FinanceMapper {
    List<Finance>finances();
    double getTotalProfit();
    double getTotalExpense();
    double getTotalRevenue();
    double getPeriodProfit(Date startDate,Date endDate);
    void updateFinance(Finance finance);
}
