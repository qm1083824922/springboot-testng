package com.sailheader.testng.strategy.sheet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Porsche
 * @since 2024/10/20 20:43
 */
@Component
public class SheetHeaderCreationStrategyFactory {
    /**
     * 策略集合
     */
    private final Map<String, SheetHeaderCreationStrategy> strategies;

    /**
     * 构造方法
     * @param context 上下文
     */
    @Autowired
    public SheetHeaderCreationStrategyFactory(ApplicationContext context) {
        this.strategies = context.getBeansOfType(SheetHeaderCreationStrategy.class);
    }

    /**
     * 获取策略
     * @param environment 环境
     * @return 策略
     */
    public SheetHeaderCreationStrategy getStrategy(String environment) {
        if (environment == null || !strategies.containsKey(environment + "Strategy")) {
            return strategies.get("standardStrategy");
        }
        return strategies.get(environment + "Strategy");
    }
}
