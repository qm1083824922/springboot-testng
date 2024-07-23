package com.sailheader.testng.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RocketMQProducerController {

    @Autowired
    private MyRocketMQProducer myRocketMQProducer;

    @GetMapping("/send")
    public String sendMessage() {
        // 发送字符串消息到指定的 topic
        myRocketMQProducer.sendMessage("boot-mq-topic", "Hello, RocketMQ!");
        return "Message sent successfully!";
    }
}
