package com.tamboot.cloud.admin.systemsvc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.tamboot.cloud.admin.systemsvc.mapper")
public class App {
    public static void main(String[] args) {
        new SpringApplication(App.class).run();
    }
}
