package com.example.dbshixun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "com.example.dbshixun.mapper")

public class DbshixunApplication {

    public static void main(String[] args) {
        SpringApplication.run(DbshixunApplication.class, args);
    }

}
