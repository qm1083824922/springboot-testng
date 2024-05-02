package com.sailheader.testng.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sailheader.testng.entity.Dept;

import java.util.List;

public interface DeptService extends IService<Dept> {
    List<Dept> getDeptByUserId(Long id);
}
