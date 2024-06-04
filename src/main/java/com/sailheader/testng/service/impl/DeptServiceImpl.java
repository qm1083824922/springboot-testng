package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.mapper.DeptMapper;
import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.service.UserDeptService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    UserDeptService userDeptService;

    public List<Dept> getDeptByUserId(Long id) {
        List<Long> deptIds = userDeptService.getDeptIdListByUserId(id);
        if (CollectionUtils.isEmpty(deptIds)) {
            return Collections.emptyList();
        }
        return this.listByIds(deptIds);
    }

    @Override
    public int updateByDeptIdAndUserId(Long deptId,Long userId) {
        return this.baseMapper.updateByDeptIdAndUserId(deptId,userId);
    }

}
