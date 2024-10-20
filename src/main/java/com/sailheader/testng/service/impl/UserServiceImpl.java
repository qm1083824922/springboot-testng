package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.converter.UserConverter;
import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.mapper.UserMapper;
import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import com.sailheader.testng.vo.req.UserRegisterVo;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    DeptService deptService;

    /**
     *  根据id获取用户信息
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public UserVO getUserById(Long id) {
        log.info("Fetching user details for id: {}", id);
        User user = this.getById(id);
        if (user == null) {
            log.info("User not found for id: {}", id);
            return null;
        }
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user,userVO);
        List<Dept> deptList = deptService.getDeptByUserId(id);
        if (!CollectionUtils.isEmpty(deptList)) {
            String deptId = deptList.stream().map(item -> String.valueOf(item.getId())).collect(Collectors.joining(StringPool.COMMA));
            String deptName = deptList.stream().map(Dept::getName).collect(Collectors.joining(StringPool.COMMA));
            userVO.setDeptId(deptId);
            userVO.setDeptName(deptName);
            log.info("User details fetched successfully for id: {}", id);
        }
        return userVO;
    }

    @Override
    public Boolean addUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO,user);
        return this.save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean updateUser(UserDTO userDTO) {
        User user = new User();
        BeanUtils.copyProperties(userDTO, user);
        return this.updateById(user);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean submit(List<UserDTO> userDTOList) {
        List<User> userList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(userDTOList)) {
            userList = userDTOList.stream().map(item -> {
                User user = new User();
                BeanUtils.copyProperties(item, user);
                return user;
            }).collect(Collectors.toList());
        }
        return this.saveOrUpdateBatch(userList);
    }

    @Override
    public int add(String name, Integer age, List<String> features) {
        return 1;
    }

    @Override
    public void register(UserRegisterVo userRegisterVo) {

    }

    /**
     * 校验用户是否合法
     *
     * @param name     用户名
     * @param password 密码
     * @return 是否合法, 合法返回true, 否则返回false
     */
    @Override
    public boolean isValid(String name, String password) {
        return false;
    }

    /**
     * 校验用户是否存在,校验失败抛出异常
     *
     * @param name 用户名
     */
    @Override
    public void checkValid(String name) {

    }

    /**
     * 根据用户名统计用户数量
     *
     * @param username 用户名
     * @return 用户数量
     */
    @Override
    public long countByUserName(String username) {
        return this.lambdaQuery().eq(User::getName, username).count();
    }

    public int getNumber() {
        System.out.println("getNumber");
        return 0;
    }
}
