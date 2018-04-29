package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
/**
 * @Author: Bob Simon
 * @Description:
 * @Date: Created in 11:40 2018\4\20
 */

/*@ComponentScan("com.example.demo")*/
@MapperScan("com.example.demo.dao")
public class DemoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("欢迎来我的宝地");
    }

}
