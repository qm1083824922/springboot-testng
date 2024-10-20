package com.sailheader.testng.strategy.packing;

import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.exception.BusinessException;

/**
 * 包装扫描策略接口
 * @author Porsche
 * @since 2024/10/19 23:50
 */
public interface PackingScanStrategy {
    /**
     * 扫描包装条码
     * @param sequenceNumber 包装条码
     * @return 成品包装信息
     * @throws BusinessException 业务异常
     */
    PackingFinished scanPackingSequenceNumber(String sequenceNumber) throws BusinessException;
}

