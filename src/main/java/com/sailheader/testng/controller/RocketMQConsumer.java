package com.sailheader.testng.controller;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "myTopic", consumerGroup = "my-consumer-group")
public class RocketMQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
        // 在这里处理接收到的消息逻辑，例如保存到数据库或执行特定操作
    }
}
