package com.sailheader.testng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.vo.UserVO;
import com.sailheader.testng.vo.req.UserRegisterVo;

import java.util.List;

public interface UserService extends IService<User> {
    /**
     *  根据id获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    UserVO getUserById(Long id);

    Boolean addUser(UserDTO userDTO);

    Boolean updateUser(UserDTO userDTO);

    Boolean submit(List<UserDTO> userDTOList);

    int add(String name, Integer age, List<String> features);

    void register(UserRegisterVo userRegisterVo);

    /**
     * 校验用户是否合法
     * @param name 用户名
     * @param password 密码
     * @return 是否合法,合法返回true,否则返回false
     */
    boolean isValid(String name,String password);

    /**
     * 校验用户是否存在,校验失败抛出异常
     * @param name 用户名
     */
    void checkValid(String name);

    /**
     * 根据用户名统计用户数量
     * @param username 用户名
     * @return 用户数量
     */
    long countByUserName(String username);
}
