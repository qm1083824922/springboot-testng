package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.UserDept;
import com.sailheader.testng.mapper.UserDeptMapper;
import com.sailheader.testng.service.UserDeptService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserDeptServiceImpl extends ServiceImpl<UserDeptMapper, UserDept> implements UserDeptService {
    /**
     * 通过用户id获取部门id列表
     *
     * @param userId 用户ID
     * @return 部门ID列表
     */
    @Override
    public List<Long> getDeptIdListByUserId(Long userId) {
        LambdaQueryWrapper<UserDept> lambdaQueryWrapper = Wrappers.lambdaQuery(UserDept.class)
                .eq(UserDept::getUserId, userId)
                .eq(UserDept::getIsDeleted, 0);
        return this.list(lambdaQueryWrapper).stream()
                .map(UserDept::getDeptId)
                .collect(Collectors.toList());
    }
}
