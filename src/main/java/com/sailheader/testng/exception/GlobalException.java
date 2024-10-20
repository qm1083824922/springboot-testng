package com.sailheader.testng.exception;

import com.sailheader.testng.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理类
 * @ControllerAdvice 用于全局异常处理,捕获Controller层抛出的异常
 * @author Porsche
 * @since  2024/10/20 11:22
 */
@ControllerAdvice
@Slf4j
public class GlobalException {

    /**
     * 处理参数校验异常
     * @param exception 参数校验异常
     * @return 参数校验结果
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public Result<Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        Map<String,String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return Result.fail(400,"参数校验失败",errorMap);
    }

    /**
     * 处理业务异常
     * @param exception 业务异常
     * @return 业务异常结果
     */
    @ExceptionHandler(BusinessException.class)
    public Result<String> handleBusinessException(BusinessException exception) {
        log.error("业务异常: {}", exception.getMessage());
        return Result.fail(400,exception.getMessage());
    }
}


