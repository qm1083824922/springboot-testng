package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
