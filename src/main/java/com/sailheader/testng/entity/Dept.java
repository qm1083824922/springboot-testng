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
 * 部门表实体
 */
@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
@TableName("sys_dept")
public class Dept {
    @TableId(type = IdType.ASSIGN_ID)
    Long id;//id
    String code;//编码
    String name;//名称
    Long parentId;//父级部门ID
    Integer level;//部门层级
    Integer sort;//排序
    LocalDateTime createTime;//创建时间
    LocalDateTime updateTime;//更新时间
    Long createUser;//创建人
    Long updateUser;//更新人
    Integer isDeleted;//是否删除

}
