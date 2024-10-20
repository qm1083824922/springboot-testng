package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sailheader.testng.entity.PackingFinished;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 成品包装 Mapper 接口
 * @author Porsche
 * @since 2024/10/19 23:42
 */
@Mapper
public interface PackingFinishedMapper extends BaseMapper<PackingFinished> {
    /**
     * 根据条码查询成品包装信息
     * @param barcode 条码
     * @return 成品包装信息
     */
    PackingFinished selectByBarcode(String barcode);
}
