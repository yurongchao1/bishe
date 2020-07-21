package com.chao.bishe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@MapperScan("com.chao.bishe.mappers")
@SpringBootApplication
public class BisheApplication  extends SpringBootServletInitializer implements WebApplicationInitializer {

          @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BisheApplication.class);
}



    public static void main(String[] args) {
        SpringApplication.run(BisheApplication.class, args);
    }

}
