package com.zqz.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-08 22:38
 * @changeRecord
 */
@EnableTransactionManagement
@ComponentScan(value = "com.zqz")
@SpringBootApplication
public class HelloMain {

    public static void main(String[] args) {
        SpringApplication.run(HelloMain.class, args);
    }
}
