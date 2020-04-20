package com.zqz.config;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-19 22:49
 * @changeRecord
 */
@Configuration
public class DateSourceConfig {

    @Bean
    public DataSource dataSource() throws Exception{
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
//        dataSource.setUrl("jdbc:mysql://localhost:3306/mytest?serverTimezone=Asia/Shanghai");
//        dataSource.setUsername("root");
//        dataSource.setPassword("");
//        return dataSource;

        Properties properties = new Properties();
        properties.setProperty("driverClassName", "com.mysql.cj.jdbc.Driver");
        properties.setProperty("url", "jdbc:mysql://localhost:3306/mytest?serverTimezone=Asia/Shanghai");
        properties.setProperty("username", "root");
        return BasicDataSourceFactory.createDataSource(properties);

    }

    public PlatformTransactionManager transactionManager() throws Exception{
        return new DataSourceTransactionManager(dataSource());
    }
}
