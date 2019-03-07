package com.yu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Auther: yuchanglong
 * @Date: 2019-3-6
 * @Description: webService 启动类
 */
@SpringBootApplication
public class WebServiceAppliction {

    public static void main(String[] args){
        SpringApplication app = new SpringApplication(WebServiceAppliction.class);
        app.run();
    }
}
