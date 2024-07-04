package com.sailheader.testng.controller;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Porsche
 * @Date 2024/6/30 17:08
 */
@Service
@RocketMQMessageListener(consumerGroup = "boot_group_1",topic = "boot-mq-topic")
public class RocketMQConsumer implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.println("Received message: " + message);
        // 在这里处理接收到的消息逻辑，例如保存到数据库或执行特定操作
    }
}
