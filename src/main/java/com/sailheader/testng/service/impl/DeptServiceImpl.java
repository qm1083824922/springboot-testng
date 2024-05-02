package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.mapper.DeptMapper;
import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.service.UserDeptService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

    UserDeptService userDeptService;

    @Override
    public List<Dept> getDeptByUserId(Long id) {
        List<Long> deptIds = userDeptService.getDeptIdListByUserId(id);
        return this.listByIds(deptIds);
    }
}
