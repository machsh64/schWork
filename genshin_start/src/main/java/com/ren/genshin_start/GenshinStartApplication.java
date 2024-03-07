package com.ren.genshin_start;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class GenshinStartApplication {

    public static void main(String[] args) {
        SpringApplication.run(GenshinStartApplication.class, args);
    }

}
