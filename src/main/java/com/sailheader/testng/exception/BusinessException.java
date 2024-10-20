package com.sailheader.testng.exception;

import cn.hutool.core.util.StrUtil;
import com.sailheader.testng.enums.biz.BusinessExceptionEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.lang3.StringUtils;

import java.text.MessageFormat;

/**
 * 业务异常类
 * @author Porsche
 * @since 2024/10/19 23:46
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BusinessException extends RuntimeException {
    /**
     * 异常码
     */
    int code;

    /**
     * 构造函数
     * @param exceptionEnum 业务异常枚举
     * @param args 参数
     */
    public BusinessException(BusinessExceptionEnum exceptionEnum, Object... args) {
        super(formatMessage(exceptionEnum.getMessage(), args));
        this.code = exceptionEnum.getCode();
    }

    /**
     * 格式化消息
     * message: 包装 {} 没有下级包装，请检查！
     * args:SEQ001
     * return: 包装 SEQ001 没有下级包装，请检查！
     * @param message 消息
     * @param args 参数
     * @return 格式化后的消息
     */
    private static String formatMessage(String message, Object... args) {
        return StrUtil.format(message, args);
    }
}

