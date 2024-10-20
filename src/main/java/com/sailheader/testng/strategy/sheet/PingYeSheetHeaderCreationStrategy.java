package com.sailheader.testng.strategy.sheet;

import com.sailheader.testng.dto.SheetHeaderDTO;
import com.sailheader.testng.entity.SheetHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 平野环境下单据表创建策略
 * @author Porsche
 * @since 2024/10/20 20:40
 */
@Component("PingYeStrategy")
@Slf4j
public class PingYeSheetHeaderCreationStrategy implements SheetHeaderCreationStrategy {
    /**
     * 创建单据表
     * @param sheetHeaderDto 单据表传输对象
     * @return 单据表
     */
    @Override
    public SheetHeader createSheet(SheetHeaderDTO sheetHeaderDto) {
        log.info("Creating sheet in PingYe environment");
        // Implement PingYe environment creation logic
        // Create and return SheetHeader
        return new SheetHeader().setSheetNo(sheetHeaderDto.getSheetNo());
    }
}
