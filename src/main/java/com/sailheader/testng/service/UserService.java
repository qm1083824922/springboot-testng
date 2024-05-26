package com.sailheader.testng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.vo.UserVO;

public interface UserService extends IService<User> {
    /**
     *  根据id获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    UserVO getUserById(Long id);

    Boolean addUser(UserDTO userDTO);
}
