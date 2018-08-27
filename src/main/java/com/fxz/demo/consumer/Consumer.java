package com.fxz.demo.consumer;

/**
 * Created by fuxiaozhi on 2018\8\27 0027.
 */
import com.fxz.demo.config.MQPropConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * 消息事件消费者
 */
@Slf4j
@Component
public class Consumer {

    private static final String queueName = "myQueue";

    @Resource
    private MQPropConfig mqPropConfig;

    /**
     * 配置消息队列-消费事件 针对消费者配置
     * @return
     */
    @Bean
    public Queue queueTechnicianBizEvent() {
        return new Queue(queueName, true); // 队列持久
    }

    /**
     * 将消费事件消息队列与交换机绑定 针对消费者配置
     *
     * @return
     */
    @Bean
    public Binding bindingTechnicianBizEvent() {
        return BindingBuilder.bind(queueTechnicianBizEvent()).to(mqPropConfig.defaultExchange()).with(queueName);
    }

    @Bean
    public SimpleMessageListenerContainer consumerMealEvent() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(mqPropConfig.connectionFactory());
        container.setQueues(queueTechnicianBizEvent());
        container.setExposeListenerChannel(true);
        container.setMaxConcurrentConsumers(2);
        container.setConcurrentConsumers(2);
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 设置确认模式手工确认
        container.setMessageListener(new ChannelAwareMessageListener() {

            public void onMessage(Message message, com.rabbitmq.client.Channel channel) throws Exception {
                boolean flag = false;
                byte[] body = message.getBody();
                String content = new String(body);
                log.info("收到消息内容 {} ", content);
                try {
                    if (StringUtils.isEmpty(content)) {
                        flag = true;
                    } else {
                        //业务代码

                        flag = true;
                    }
                } catch (Exception e) {
                    log.info("处理消息失败 {} ", content, e);
                } finally {
                    if (flag) {
                        log.info("消息消费成功 {} ", content);
                        channel.basicAck(message.getMessageProperties().getDeliveryTag(), false); // 确认消息成功消费
                    }
                }
            }
        });
        return container;
    }
}
