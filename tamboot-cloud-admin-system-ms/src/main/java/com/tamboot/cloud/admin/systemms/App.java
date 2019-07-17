package com.tamboot.cloud.admin.systemms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.tamboot.cloud.admin.systemms.mapper")
public class App {
    public static void main(String[] args) {
        new SpringApplication(App.class).run();
    }
}
