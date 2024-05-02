package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sailheader.testng.entity.Dept;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DeptMapper extends BaseMapper<Dept> {
}
