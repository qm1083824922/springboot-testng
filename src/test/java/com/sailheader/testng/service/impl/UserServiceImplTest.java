package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.mapper.UserMapper;
import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.vo.UserVO;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Field;
import static org.mockito.Mockito.*;
import static org.testng.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class UserServiceImplTest {

    @Mock
    private UserMapper userMapper;

    @Mock
    private DeptService deptService;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeMethod
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        // 使用反射设置 baseMapper
        Field baseMapperField = ServiceImpl.class.getDeclaredField("baseMapper");
        baseMapperField.setAccessible(true);
        baseMapperField.set(userService, userMapper);

        // 重置模拟对象
        reset(userMapper, deptService);
    }

    @Test
    public void testGetUserById() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("张三");
        when(userMapper.selectById(userId)).thenReturn(mockUser);

        Dept dept1 = new Dept();
        dept1.setId(1L);
        dept1.setName("HR");
        Dept dept2 = new Dept();
        dept2.setId(2L);
        dept2.setName("Finance");
        List<Dept> deptList = Arrays.asList(dept1, dept2);
        when(deptService.getDeptByUserId(userId)).thenReturn(deptList);

        // Act
        UserVO result = userService.getUserById(userId);

        // Assert
        assertNotNull(result);
        assertEquals(result.getName(), "张三");
        assertEquals(result.getDeptId(), "1,2");
        assertEquals(result.getDeptName(), "HR,Finance");
    }

    @Test
    public void testGetUserByIdWithNoDept() {
        // Arrange
        Long userId = 1L;
        User mockUser = new User();
        mockUser.setId(userId);
        mockUser.setName("张三");
        when(userMapper.selectById(userId)).thenReturn(mockUser);

        // 模拟部门信息为空
        when(deptService.getDeptByUserId(userId)).thenReturn(Collections.emptyList());

        // Act
        UserVO result = userService.getUserById(userId);

        // 手动清理或确认状态
        System.out.println("Dept ID: " + result.getDeptId());  // 打印部门ID
        System.out.println("Dept Name: " + result.getDeptName());  // 打印部门名称

        // Assert
        assertNotNull(result);
        assertEquals(result.getName(), "张三");
        assertNull(result.getDeptId(), "Dept ID should be null when no departments are associated.");
        assertNull(result.getDeptName(), "Dept Name should be null when no departments are associated.");
    }
}