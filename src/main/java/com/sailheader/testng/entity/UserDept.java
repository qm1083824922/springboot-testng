package com.sailheader.testng.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * 用户部门关系表实体
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("sys_user_dept")
public class UserDept {
    Long id;
    Long userId;//用户ID
    Long deptId;//部门ID
    LocalDateTime createTime;//创建时间
    LocalDateTime updateTime;//更新时间
    String createBy;//创建人
    String updateBy;//更新人
    Integer isDeleted;//是否删除
}
