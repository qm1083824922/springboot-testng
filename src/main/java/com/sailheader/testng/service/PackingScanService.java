/**
 * @author Porsche
 * @Date 2024/10/20 00:05
 */
package com.sailheader.testng.service;

import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.exception.BusinessException;

/**
 * 包装扫描服务接口
 * @author Porsche
 * @since 2024/10/20 00:05
 */
public interface PackingScanService {
    /**
     * 扫描包装条码
     * @param sequenceNumber 包装条码
     * @param type 包装类型
     * @return 成品包装信息
     * @throws BusinessException 业务异常
     */
    PackingFinished scanPackingSequenceNumber(String sequenceNumber, String type) throws BusinessException;
}
