package com.sailheader.testng.service.impl;

import com.sailheader.testng.mapper.UserDeptMapper;
import jakarta.annotation.Resource;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class UserDeptServiceImplTest {

    private UserDeptServiceImpl userDeptServiceImplUnderTest;

    @Resource
    private UserDeptMapper userDeptMapper;

    @BeforeMethod
    public void setUp() {
        userDeptServiceImplUnderTest = new UserDeptServiceImpl();
    }

    @Test
    public void testGetDeptIdListByUserId() {
        assertEquals(List.of(0L), userDeptServiceImplUnderTest.getDeptIdListByUserId(0L));
        assertEquals(Collections.emptyList(), userDeptServiceImplUnderTest.getDeptIdListByUserId(0L));
    }
}
