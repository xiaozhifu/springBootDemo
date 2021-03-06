package com.fxz.demo.controller.rabbit;

import com.fxz.demo.rabbit.CallBackSender;
import com.fxz.demo.rabbit.HelloSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fuxiaozhi on 2018\8\6 0006.
 */

@RestController
@RequestMapping("/rabbit")
public class RabbitTest {

    @Autowired
    private HelloSender helloSender;

    @Autowired
    private CallBackSender callBackSender;

    @RequestMapping("/hello")
    public void hello() {
        helloSender.send();
    }

    @RequestMapping("/testCallback")
    public void callback() {
        callBackSender.send();
    }

}
