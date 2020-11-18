package com.example.wings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author Administrator
 */
@SpringBootApplication
public class WingsApplication {

    public static void main(String[] args) {
        SpringApplication.run(WingsApplication.class, args);
    }

}
