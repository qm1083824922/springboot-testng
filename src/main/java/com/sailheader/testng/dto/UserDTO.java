package com.sailheader.testng.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

/**
 * 用户数据传输对象
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDTO {
    /**
     * ID
     */
    Long id;
    /**
     * 姓名
     */
    String name;
    /**
     * 年龄
     */
    Integer age;
    /**
     * 年龄
     */
    String email;
}
