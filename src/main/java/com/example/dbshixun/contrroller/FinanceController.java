package com.example.dbshixun.contrroller;

import com.example.dbshixun.pojo.Finance;
import com.example.dbshixun.service.FinanceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.Date;
import java.util.List;

/**
 * @ClassName FinanceController
 * @author cancet
 * @Date 2023/4/26
 * @Description 财务表的控制层
 */
@RestController
@RequestMapping("/finance")
@Tag(name = "FinanceController")
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @GetMapping("/finances")
    @Operation(summary = "财务列表",description = "返回财务表中的所有信息")
    public List<Finance>finances(){
        return financeService.finances();
    }

    @GetMapping("/getTotalRevenue")
    @Operation(summary = "总收入",description = "返回收入总和")
    public double getTotalRevenue(){
        return financeService.getTotalRevenue();
    }
    @GetMapping("/getTotalExpense")
    @Operation(summary = "总支出",description = "返回支出总和")
    public double getTotalExpense(){
        return financeService.getTotalExpense();
    }
    @GetMapping("/getTotalProfit")
    @Operation(summary = "总利润",description = "返回利润总和")
    public double getTotalProfit(){
        return financeService.getTotalProfit();
    }
    @GetMapping("/getPeriodProfit")
    @Operation(summary = "时段利润",description = "返回一段时间内的利润之和")
    public double getPeriodProfit(Date startDate, Date endDate){
        return financeService.getPeriodProfit(startDate,endDate);
    }
}
