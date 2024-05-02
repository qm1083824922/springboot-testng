package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.mapper.UserMapper;
import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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
        UserVO userVO = new UserVO();
        User user = this.getById(id);
        if (user == null) {
            log.warn("User not found for id: {}", id);
            return null;
        }
        BeanUtils.copyProperties(user,userVO);
        List<Dept> deptList = deptService.getDeptByUserId(id);
        if (CollectionUtils.isEmpty(deptList)) {
            userVO.setDeptId(null);
            userVO.setDeptName(null);
            return userVO;
        }else {
            String deptId = deptList.stream().map(item -> String.valueOf(item.getId())).collect(Collectors.joining(StringPool.COMMA));
            String deptName = deptList.stream().map(Dept::getName).collect(Collectors.joining(StringPool.COMMA));
            userVO.setDeptId(deptId);
            userVO.setDeptName(deptName);
            log.info("User details fetched successfully for id: {}", id);
            return userVO;
        }
    }
}
