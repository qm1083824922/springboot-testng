package com.sailheader.testng.strategy.sheet;

import com.sailheader.testng.dto.SheetHeaderDTO;
import com.sailheader.testng.entity.SheetHeader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 标准环境下单据表创建策略
 * @author Porsche
 * @since 2024-10-20
 */
@Component("standardStrategy")
@Slf4j
public class StandardSheetHeaderCreationStrategy implements SheetHeaderCreationStrategy {
    /**
     * 创建单据表
     * @param sheetHeaderDto 单据表传输对象
     * @return 单据表
     */
    @Override
    public SheetHeader createSheet(SheetHeaderDTO sheetHeaderDto) {
        log.info("Creating sheet in standard environment");
        // Implement standard environment creation logic
        if (sheetHeaderDto.getSourceNo() == null) {
            throw new IllegalArgumentException("SourceNo cannot be null in standard environment");
        }
        // Create and return SheetHeader
        return new SheetHeader().setSheetNo(sheetHeaderDto.getSheetNo());
    }
}

