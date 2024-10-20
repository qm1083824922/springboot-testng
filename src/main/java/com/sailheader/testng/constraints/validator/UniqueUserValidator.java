package com.sailheader.testng.constraints.validator;

import com.sailheader.testng.constraints.UniqueUser;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.service.UserService;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.Data;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 用户唯一性校验器
 * @author Porsche
 * @since 2024/10/20 11:55
 */
@Data
@Scope("prototype") // 每次请求创建一个新的实例,防止线程安全问题
@Component
public class UniqueUserValidator implements ConstraintValidator<UniqueUser,String> {

    @Autowired
    private UserService userService;

    private String[] baned;

    /**
     * 初始化方法,可以获取注解中的属性值
     * @param constraintAnnotation 注解
     */
    @Override
    public void initialize(UniqueUser constraintAnnotation) {
        String[] baned = constraintAnnotation.baned();
    }

    /**
     * 校验逻辑
     * @param value 待校验的值
     * @param constraintValidatorContext 上下文
     * @return 是否校验通过
     */
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        long count = userService.countByUserName(value);
        // 判断是否在禁用列表中
        long counted = Arrays.stream(baned).filter(b -> b.equals(value)).count();
        return count == 0 && counted == 0;
    }
}
