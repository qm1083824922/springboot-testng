package com.sailheader.testng.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.mapper.DeptMapper;
import com.sailheader.testng.service.UserDeptService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.util.CollectionUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;

import static org.mockito.Mockito.*;

public class DeptServiceImplTest {

    @InjectMocks
    @Spy
    private DeptServiceImpl deptServiceImpl;

    @Mock
    private DeptMapper deptMapper;

    @Mock
    private UserDeptService userDeptService;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        // 注入baseMapper
        injectBaseMapper();
    }

    private void injectBaseMapper() {
        try {
            Field baseMapperField = ServiceImpl.class.getDeclaredField("baseMapper");
            baseMapperField.setAccessible(true);
            baseMapperField.set(deptServiceImpl, deptMapper);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetDeptByUserId_withValidId() {
        Long userId = 1L;
        List<Long> deptIds = List.of(1L, 2L, 3L);
        List<Dept> depts = List.of(new Dept(), new Dept(), new Dept());

        when(userDeptService.getDeptIdListByUserId(userId)).thenReturn(deptIds);
        when(deptServiceImpl.listByIds(deptIds)).thenReturn(depts);

        List<Dept> result = deptServiceImpl.getDeptByUserId(userId);

        Assert.assertEquals(result.size(), 3);
        verify(userDeptService, times(1)).getDeptIdListByUserId(userId);
        verify(deptServiceImpl, times(2)).listByIds(deptIds);
    }

    @Test
    public void testGetDeptByUserId_withEmptyDeptIds() {
        Long userId = 1L;
        when(userDeptService.getDeptIdListByUserId(userId)).thenReturn(Collections.emptyList());

        List<Dept> result = deptServiceImpl.getDeptByUserId(userId);

        Assert.assertTrue(CollectionUtils.isEmpty(result));
        verify(userDeptService, times(1)).getDeptIdListByUserId(userId);
        verify(deptServiceImpl, never()).listByIds(anyList());
    }

    @Test
    public void testUpdateByDeptIdAndUserId() {
        Long deptId = 1L;
        Long userId = 1L;
        int updateCount = 1;

        when(deptMapper.updateByDeptIdAndUserId(deptId, userId)).thenReturn(updateCount);

        int result = deptServiceImpl.updateByDeptIdAndUserId(deptId, userId);

        Assert.assertEquals(result, updateCount);
        verify(deptMapper, times(1)).updateByDeptIdAndUserId(deptId, userId);
    }
}
