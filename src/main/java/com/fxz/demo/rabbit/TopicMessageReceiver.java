package com.fxz.demo.rabbit;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by fuxiaozhi on 2018\8\9 0009.
 */

@Component
@RabbitListener(queues = "topic.messages")
public class TopicMessageReceiver {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicMessageReceiver  : " +msg);
    }

}
