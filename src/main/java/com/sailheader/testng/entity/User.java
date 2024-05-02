package com.sailheader.testng.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * 用户表实体
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("sys_user")
public class User {
    @TableId(type = IdType.ASSIGN_ID)
    Long id;//id
    String name;//姓名
    Integer age;//年龄
    String email;//年龄
    LocalDateTime createTime;//创建时间
    LocalDateTime updateTime;//更新时间
    Long createUser;//创建人
    Long updateUser;//更新人
}
