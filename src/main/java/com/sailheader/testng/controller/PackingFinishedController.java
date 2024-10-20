package com.sailheader.testng.controller;

import com.sailheader.testng.entity.PackingFinished;
import com.sailheader.testng.exception.BusinessException;
import com.sailheader.testng.service.PackingScanService;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 成品包装 控制器
 * @author Porsche
 * @since 2024/10/19 23:40
 */
@RestController
@AllArgsConstructor
@RequestMapping("/packing-finished")
@FieldDefaults(makeFinal = true, level = lombok.AccessLevel.PRIVATE)
@Slf4j
public class PackingFinishedController {

    PackingScanService packingScanService;

    /**
     * 扫描包装条码
     *
     * @param sequenceNumber 包装条码
     * @param type           包装类型
     * @return 成品包装信息
     */
    @GetMapping("/scan-packing")
    public PackingFinished scanPacking(@RequestParam String sequenceNumber, @RequestParam String type) {
        log.info("扫描包装条码: {}, 类型: {}", sequenceNumber, type);
        try {
            return packingScanService.scanPackingSequenceNumber(sequenceNumber, type);
        } catch (BusinessException e) {
            // 处理业务异常
            throw new RuntimeException(e.getMessage());
        }
    }
}
