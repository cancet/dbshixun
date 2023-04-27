package com.example.dbshixun.service;

import com.example.dbshixun.mapper.FinanceMapper;
import com.example.dbshixun.pojo.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinanceService {
    @Autowired
    private FinanceMapper financeMapper;
    public List<Finance>finances(){
        return financeMapper.finances();
    }
    public double getTotalRevenue(){
        return financeMapper.getTotalRevenue();
    }
    public double getTotalExpense(){
        return financeMapper.getTotalExpense();
    }
    public double getTotalProfit(){
        return financeMapper.getTotalProfit();
    }
    public double getPeriodProfit(Date startDate, Date endDate){
        return financeMapper.getPeriodProfit(startDate,endDate);
    }
}
