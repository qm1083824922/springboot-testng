package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sailheader.testng.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
    int updateByDeptIdAndUserId(@Param("deptId") Long deptId,@Param("userId") Long userId);
}
