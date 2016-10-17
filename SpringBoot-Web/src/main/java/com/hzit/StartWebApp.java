package com.hzit;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2016/9/26.
 */
@SpringBootApplication
@ComponentScan({"com.fc","com.hzit"})//扫描com.fc和com.hzit包下面的组件
@MapperScan("com.hzit.dao.mapper")//扫描SpringBoot-Core下面的所有mapper里面的接口
//继承SpringBootServletInitializer类后，将初始化一些servlet所需要的功能
public class StartWebApp extends SpringBootServletInitializer{
//    public static void main(String[] args) {
//        SpringApplication.run(Test.class,args);
//    }
    @Bean  //用来自定义一个对象
    public Object getObject(){
        System.out.println("自定义对象被调用");
        return new Object();
    }
}
