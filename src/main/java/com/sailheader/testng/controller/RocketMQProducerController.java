package com.sailheader.testng.controller;

import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Porsche
 * @Date 2024/6/30 17:05
 */
@RestController
@RequestMapping("/rocketmq/producer")
public class RocketMQProducerController {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    @GetMapping("/send")
    public String sendMessage() {
        // 发送字符串消息到指定的 topic
        rocketMQTemplate.convertAndSend("myTopic", "Hello, RocketMQ!");
        return "Message sent successfully!";
    }
}
