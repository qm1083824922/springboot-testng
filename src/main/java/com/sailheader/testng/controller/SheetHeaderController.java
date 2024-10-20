package com.sailheader.testng.controller;

import com.sailheader.testng.dto.SheetHeaderDTO;
import com.sailheader.testng.entity.SheetHeader;
import com.sailheader.testng.exception.BusinessException;
import com.sailheader.testng.service.SheetHeaderService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * 单据表 控制器
 */
@RestController
@AllArgsConstructor
@RequestMapping("/sheet-header")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class SheetHeaderController {

    SheetHeaderService sheetHeaderService;

    /**
     * 根据单据单号查询单据信息
     *
     * @param sheetHeaderDto 单据传输对象
     * @return 单据信息
     */
    @PostMapping("/create-sheet")
    public SheetHeader getSheet(@RequestBody SheetHeaderDTO sheetHeaderDto) {
        log.info("查询单据单号: {}", sheetHeaderDto);
        try {
            return sheetHeaderService.createSheet(sheetHeaderDto);
        } catch (BusinessException e) {
            // 处理业务异常
            throw new RuntimeException(e.getMessage());
        }
    }
}