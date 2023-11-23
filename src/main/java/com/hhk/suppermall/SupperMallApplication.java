package com.hhk.suppermall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hhk.suppermall.mapper")
public class SupperMallApplication {

    public static void main(String[] args) {
        SpringApplication.run(SupperMallApplication.class, args);
    }

}
