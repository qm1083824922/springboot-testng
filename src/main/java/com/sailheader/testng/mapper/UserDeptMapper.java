package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sailheader.testng.entity.UserDept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDeptMapper extends BaseMapper<UserDept> {
}
