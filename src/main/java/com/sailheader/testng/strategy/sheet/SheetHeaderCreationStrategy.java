package com.sailheader.testng.strategy.sheet;

import com.sailheader.testng.dto.SheetHeaderDTO;
import com.sailheader.testng.entity.SheetHeader;

/**
 * 单据表创建策略
 * @author porsche
 * @since 2024-10-20
 */
public interface SheetHeaderCreationStrategy {
    /**
     * 创建单据表
     * @param sheetHeaderDto 单据表传输对象
     * @return 单据表
     */
    SheetHeader createSheet(SheetHeaderDTO sheetHeaderDto);
}
