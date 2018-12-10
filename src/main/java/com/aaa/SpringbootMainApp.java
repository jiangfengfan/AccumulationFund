package com.aaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * className:SpringbootMainApp
 * discription:
 * author:zz
 * createTime:2018-12-03 19:48
 */
@SpringBootApplication
@MapperScan("com.aaa.dao")
public class SpringbootMainApp {
    /**
     * 主函数
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootMainApp.class);
    }
}
