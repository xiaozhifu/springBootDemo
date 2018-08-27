package com.fxz.demo.service;

import com.fxz.demo.config.MQPropConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fuxiaozhi on 2018\8\27 0027.
 */
@Service
public class MQServiceImpl {
    private static final Logger log = LoggerFactory.getLogger(MQServiceImpl.class);
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private MQPropConfig mqConfig;

    public MQServiceImpl() {
    }

    public void send(String msg, String routeKey) {
        CorrelationData correlationData = new CorrelationData(msg);

        try {
            log.info("发送 exchange:{} routeKey:{} 消息 {} ", new Object[]{this.mqConfig.getExDefault(), routeKey, msg});
            this.rabbitTemplate.convertAndSend(this.mqConfig.getExDefault(), routeKey, msg, correlationData);
        } catch (Exception var5) {
            log.info("发送失败，重试 exchange:{} routeKey:{} 消息 {} ", new Object[]{this.mqConfig.getExDefault(), routeKey, msg});
            this.rabbitTemplate.convertAndSend(this.mqConfig.getExDefault(), routeKey, msg, correlationData);
        }

    }

    public void send(String msg, String exchange, String routeKey) {
        CorrelationData correlationData = new CorrelationData(msg);

        try {
            log.info("发送 exchange:{} routeKey:{} 消息 {} ", new Object[]{this.mqConfig.getExDefault(), routeKey, msg});
            this.rabbitTemplate.convertAndSend(exchange, routeKey, msg, correlationData);
        } catch (Exception var6) {
            log.info("发送失败，重试 exchange:{} routeKey:{} 消息 {} ", new Object[]{this.mqConfig.getExDefault(), routeKey, msg});
            this.rabbitTemplate.convertAndSend(exchange, routeKey, msg, correlationData);
        }

    }

    public void sendWithDelay(String msg, String routeKey, final int seconds) {
        try {
            this.rabbitTemplate.convertAndSend(this.mqConfig.getExDelay(), routeKey, msg, new MessagePostProcessor() {
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setHeader("x-delay", Integer.valueOf(seconds * 1000));
                    return message;
                }
            });
        } catch (Exception var5) {
            log.error("sendWithDelay error, retry exchange:{} routeKey:{} 消息 {} ", new Object[]{this.mqConfig.getExDelay(), routeKey, msg});
            this.rabbitTemplate.convertAndSend(this.mqConfig.getExDelay(), routeKey, msg, new MessagePostProcessor() {
                public Message postProcessMessage(Message message) throws AmqpException {
                    message.getMessageProperties().setHeader("x-delay", Integer.valueOf(seconds * 1000));
                    return message;
                }
            });
        }

    }
}
