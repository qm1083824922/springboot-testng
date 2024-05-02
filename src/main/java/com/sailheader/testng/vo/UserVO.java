package com.sailheader.testng.vo;


import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)

public class UserVO {

    Long id;//id
    String name;//姓名
    Integer age;//年龄
    String email;//年龄
    String deptId;//部门id
    String deptName;//部门名称
    String createTime;//创建时间
    String updateTime;//更新时间
    Long createUser;//创建人
    String createUserName;//创建人姓名
    Long updateUser;//更新人
    String updateUserName;//更新人姓名
}
