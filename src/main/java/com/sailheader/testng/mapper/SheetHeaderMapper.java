package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sailheader.testng.entity.SheetHeader;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 单据表 Mapper 接口
 */
@Mapper
public interface SheetHeaderMapper extends BaseMapper<SheetHeader> {
    /**
     * 根据单据单号查询单据信息
     * @param sheetNo 单据单号
     * @return 单据信息
     */
    SheetHeader selectBySheetNo(String sheetNo);
}