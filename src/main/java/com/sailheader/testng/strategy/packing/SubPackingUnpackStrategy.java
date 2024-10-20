package com.sailheader.testng.strategy.packing;

import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.enums.biz.BusinessExceptionEnum;
import com.sailheader.testng.exception.BusinessException;
import com.sailheader.testng.mapper.PackingFinishedMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 子包装拆包策略接口
 * @author Porsche
 * @since 2024/10/19 23:56
 */
@Component("SubPackingUnpack")
@Slf4j
public class SubPackingUnpackStrategy implements PackingScanStrategy {

    @Autowired
    private PackingFinishedMapper packingFinishedMapper;

    @Override
    public PackingFinished scanPackingSequenceNumber(String sequenceNumber) throws BusinessException {
        log.info("开始子包装拆包扫描={}", sequenceNumber);
        PackingFinished packingFinished = packingFinishedMapper.selectByBarcode(sequenceNumber);
        // 包装条码不存在
        if (packingFinished == null) {
            throw new BusinessException(BusinessExceptionEnum.BARCODE_NOT_EXIST, sequenceNumber);
        }
        // 假设1表示已入库状态
        if (packingFinished.getStatus() != 1) {
            throw new BusinessException(BusinessExceptionEnum.NOT_IN_STOCK);
        }
        // 假设0表示没有下级包装
        if (!packingFinished.getIsHasSubPack()) {
            throw new BusinessException(BusinessExceptionEnum.NO_SUB_PACK, sequenceNumber);
        }
        return packingFinished;
    }
}
