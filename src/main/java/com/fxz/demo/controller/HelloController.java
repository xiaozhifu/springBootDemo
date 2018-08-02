package com.fxz.demo.controller;

import com.fxz.demo.entity.config.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fuxiaozhi on 2018\6\22 0022.
 */

@RestController
@RequestMapping("test")
public class HelloController {

    @Autowired
    private Student student;

    @RequestMapping("/sayHello")
    public String sayHello(){
        return "hello world!";
    }

    @RequestMapping("student")
    public String student(){
        return  "name:" + student.getName() + ",sex:" + student.getSex() + ",age:" + student.getAge();
    }

    @Value("${randomValue}")
    private String randomValue;
    @RequestMapping("/random")
    public String random(){
        return randomValue;
    }

}
