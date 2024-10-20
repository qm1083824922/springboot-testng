package com.sailheader.testng.service.impl;

/**
 * @author Porsche
 * @Date 2024/10/20 00:04
 */
import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.enums.biz.BusinessExceptionEnum;
import com.sailheader.testng.exception.BusinessException;
import com.sailheader.testng.service.PackingScanService;
import com.sailheader.testng.strategy.packing.PackingScanStrategy;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
/**
 * 包装扫描服务实现类
 * @since 2024/10/20 00:04
 */
@Service
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Slf4j
public class PackingScanServiceImpl implements PackingScanService {

    Map<String, PackingScanStrategy> strategyMap;

    @Autowired
    public PackingScanServiceImpl(Map<String, PackingScanStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    /**
     * 扫描包装条码
     * @param sequenceNumber 包装条码
     * @param type 包装类型
     * @return 成品包装信息
     * @throws BusinessException 业务异常
     */
    @Override
    public PackingFinished scanPackingSequenceNumber(String sequenceNumber, String type) throws BusinessException {
        log.info("扫描包装条码: {}, 类型: {}", sequenceNumber, type);
        PackingScanStrategy strategy = strategyMap.get(type);
        // 未知的解包类型
        if (strategy == null) {
            throw new BusinessException(BusinessExceptionEnum.UNKNOWN_UNPACK_TYPE);
        }
        // 调用具体的扫包装条码策略
        return strategy.scanPackingSequenceNumber(sequenceNumber);
    }
}

