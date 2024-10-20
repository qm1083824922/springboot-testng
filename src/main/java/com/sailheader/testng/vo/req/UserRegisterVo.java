package com.sailheader.testng.vo.req;

import com.sailheader.testng.constraints.UniqueUser;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * @author Porsche
 * @since 2024/10/20 11:08
 */
@Data
@Schema(description = "用户注册传输对象")
public class UserRegisterVo {
    /**
     * 用户名
     */
    @NotBlank(message = "{username.notEmpty}")
    @Length(min = 4, max = 20)
    @UniqueUser(message = "{username.exist}",baned = {"admin","root"})
    @Schema(description = "名称",defaultValue = "张飞",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String username;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @Length(min = 6, max = 20,message = "密码长度必须在6-20位之间")
    @Schema(description = "密码",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String password;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @Schema(description = "邮箱",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String email;
    /**
     * 手机号
     */
    @Length(min = 11, max = 11,message = "手机号格式不正确")
    @Schema(description = "手机号",nullable = true,requiredMode = Schema.RequiredMode.REQUIRED)
    String phone;
}
