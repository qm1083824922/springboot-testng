package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.dto.SheetHeaderDTO;
import com.sailheader.testng.entity.SheetHeader;
import com.sailheader.testng.mapper.SheetHeaderMapper;
import com.sailheader.testng.service.SheetHeaderService;
import com.sailheader.testng.strategy.sheet.SheetHeaderCreationStrategy;
import com.sailheader.testng.strategy.sheet.SheetHeaderCreationStrategyFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 单据表 服务实现类
 */
@Service
public class SheetHeaderServiceImpl extends ServiceImpl<SheetHeaderMapper, SheetHeader> implements SheetHeaderService {

    @Value("${customer.environment}")
    private String environment;

    private final SheetHeaderCreationStrategyFactory strategyFactory;

    public SheetHeaderServiceImpl(SheetHeaderCreationStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    /**
     * 根据单据传输对象创建单据信息
     * 1.针对标准环境下environment值为空，直接创建单据信息时，会校验sourceNo是否为空
     * 2.针对平野环境下，environment值为pingYe 创建单据时，直接创建单据信息
     * @param sheetHeaderDto 单据传输对象
     * @return 单据信息
     */
    @Override
    public SheetHeader createSheet(SheetHeaderDTO sheetHeaderDto) {
        SheetHeaderCreationStrategy strategy = strategyFactory.getStrategy(environment);
        return strategy.createSheet(sheetHeaderDto);
    }
}