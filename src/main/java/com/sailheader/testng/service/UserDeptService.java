package com.sailheader.testng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sailheader.testng.entity.UserDept;

import java.util.List;

public interface UserDeptService extends IService<UserDept> {
    /**
     *  通过用户id获取部门id列表
     * @param userId 用户ID
     * @return 部门ID列表
     */
    List<Long> getDeptIdListByUserId(Long userId);
}
