package com.sailheader.testng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sailheader.testng.dto.SheetHeaderDTO;
import com.sailheader.testng.entity.SheetHeader;

/**
 * 单据表 服务类
 */
public interface SheetHeaderService extends IService<SheetHeader> {
    /**
     * 根据单据单号查询单据信息
     * @param sheetHeaderDto 单据传输对象
     * @return 单据信息
     */
    SheetHeader createSheet(SheetHeaderDTO sheetHeaderDto);
}