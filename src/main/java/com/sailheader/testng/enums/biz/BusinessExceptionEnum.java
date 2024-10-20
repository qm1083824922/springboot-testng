package com.sailheader.testng.enums.biz;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * 业务异常枚举
 * @author Porsche
 * @since  2024/10/19 23:45
 */
@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public enum BusinessExceptionEnum {
    BARCODE_NOT_EXIST(1001, "包装条码[{}]系统中不存在，请检查！"),
    NOT_IN_STOCK(1002, "只有库内包装才能进行拆包！"),
    HAS_PARENT_PACK(1003, "包装条码[{}]有上级包装，请先进行包装解绑后，再进行内包拆分！"),
    NO_SUB_PACK(1004, "包装[{}]没有下级包装，请检查！"),
    UNKNOWN_UNPACK_TYPE(1005, "未知的拆包类型！");
    /**
     * 异常码
     */
    int code;
    /**
     * 异常消息
     */
    String message;
}

