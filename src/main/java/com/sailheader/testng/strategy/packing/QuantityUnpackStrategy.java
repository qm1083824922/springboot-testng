package com.sailheader.testng.strategy.packing;

import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.enums.biz.BusinessExceptionEnum;
import com.sailheader.testng.exception.BusinessException;
import com.sailheader.testng.mapper.PackingFinishedMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 数量拆包策略接口
 * @author Porsche
 * @since 2024/10/20 00:00
 */
@Component("QuantityUnpack")
@Slf4j
public class QuantityUnpackStrategy implements PackingScanStrategy {

    @Autowired
    private PackingFinishedMapper packingFinishedMapper;

    @Override
    public PackingFinished scanPackingSequenceNumber(String sequenceNumber) throws BusinessException {
        log.info("开始数量拆包扫描={}", sequenceNumber);
        PackingFinished packingFinished = packingFinishedMapper.selectByBarcode(sequenceNumber);
        if (packingFinished == null) {
            throw new BusinessException(BusinessExceptionEnum.BARCODE_NOT_EXIST, sequenceNumber);
        }
        if (packingFinished.getStatus() != 1) { // 假设1表示已入库状态
            throw new BusinessException(BusinessExceptionEnum.NOT_IN_STOCK);
        }
        if (packingFinished.getParentId() != null) {
            throw new BusinessException(BusinessExceptionEnum.HAS_PARENT_PACK, sequenceNumber);
        }
        return packingFinished;
    }
}
