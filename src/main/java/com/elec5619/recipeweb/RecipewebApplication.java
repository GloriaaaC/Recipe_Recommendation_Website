package com.elec5619.recipeweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.elec5619.recipeweb.mapper", "com.elec5619.recipeweb.mapper.*"})
public class RecipewebApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipewebApplication.class, args);
    }

}
