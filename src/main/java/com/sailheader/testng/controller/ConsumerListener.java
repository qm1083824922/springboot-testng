package com.sailheader.testng.controller;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RocketMQMessageListener(consumerGroup = "boot_group_1",topic = "boot-mq-topic")
public class ConsumerListener implements RocketMQListener<String> {

    private static final Logger log = LoggerFactory.getLogger(ConsumerListener.class);

    @Override
    public void onMessage(String message) {
        log.info("\n=====\n message：{} \n=====\n",message);
    }
}
