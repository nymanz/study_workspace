package com.zqz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 赵乾泽
 * @version 1.0
 * @title
 * @description
 *
 * @created 2020-04-08 22:52
 * @changeRecord
 */
@RequestMapping("/hello")
@RestController
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping(value = "/world", method = RequestMethod.GET)
    public String helloSpringBoot(){
        logger.info("helloController helloSpringBoot");
        return "Hello SpringBoot";
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public String hellodb() throws SQLException {
        showConnection();
        return "Hello db";
    }

    @Autowired
    private DataSource dataSource;

    private void showConnection() throws SQLException{
        logger.info(dataSource.toString());
        Connection conn = dataSource.getConnection();
        logger.info(conn.toString());
        conn.close();
    }
}
