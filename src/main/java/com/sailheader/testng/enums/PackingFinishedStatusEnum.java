package com.sailheader.testng.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 成品包装状态枚举
 * @author Porsche
 * @since 2024/10/19 23:35
 */
@Getter
@AllArgsConstructor
public enum PackingFinishedStatusEnum {

    INBOUND(1, "已入库"),
    OUTBOUND(2, "已出库"),
    LOCKED(3, "锁定"),
    SCRAPPED(4, "报废");

    private final int code;
    private final String value;
}
