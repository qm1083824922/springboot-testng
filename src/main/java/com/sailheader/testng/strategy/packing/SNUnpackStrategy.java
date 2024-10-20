package com.sailheader.testng.strategy.packing;

import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.enums.biz.BusinessExceptionEnum;
import com.sailheader.testng.exception.BusinessException;
import com.sailheader.testng.mapper.PackingFinishedMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * SN解包策略接口
 * @author Porsche
 * @since 2024/10/19 23:51
 */
@Component("SN")
@Slf4j
public class SNUnpackStrategy implements PackingScanStrategy {

    @Autowired
    private PackingFinishedMapper packingFinishedMapper;

    /**
     * 扫描包装条码
     * @param sequenceNumber 包装条码
     * @return 成品包装信息
     * @throws BusinessException 业务异常
     */
    @Override
    public PackingFinished scanPackingSequenceNumber(String sequenceNumber) throws BusinessException {
        log.info("开始SN解包扫描={}", sequenceNumber);
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
