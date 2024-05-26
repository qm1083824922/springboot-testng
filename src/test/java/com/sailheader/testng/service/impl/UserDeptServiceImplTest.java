package com.sailheader.testng.service.impl;

import com.sailheader.testng.entity.UserDept;
import com.sailheader.testng.mapper.UserDeptMapper;
import com.sailheader.testng.service.UserDeptService;
import jakarta.annotation.Resource;
import org.assertj.core.api.Assertions;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static org.testng.Assert.assertEquals;

@SpringBootTest(classes = UserDeptServiceImpl.class)
public class UserDeptServiceImplTest extends AbstractTestNGSpringContextTests {

    private UserDeptServiceImpl userDeptServiceImplUnderTest;
    @Autowired
    private UserDeptService userDeptService;

    @Test
    public void testGetDeptIdListByUserId() {
        assertEquals(List.of(0L), userDeptServiceImplUnderTest.getDeptIdListByUserId(0L));
        assertEquals(Collections.emptyList(), userDeptServiceImplUnderTest.getDeptIdListByUserId(0L));
    }

    @Test
    public void testGetDeptIdListByUserId2() {

        UserDept userDept = userDeptService.getById(1L);
        Assert.assertFalse(Objects.nonNull(userDept));
    }
}
