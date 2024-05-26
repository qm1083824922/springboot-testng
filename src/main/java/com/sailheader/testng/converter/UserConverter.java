package com.sailheader.testng.converter;

import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConverter {
    //使用工厂方法获取实例
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);
    User userDtoToUser(UserDTO userDTO);
    User userToUserDto(UserDTO userDTO);
    UserVO userToUserVo(User user);
    List<User> userDtoToUser(List<UserDTO> userDTOList);
}
