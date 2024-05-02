package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sailheader.testng.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

public class UserMapperTest {

    @Mock
    private UserMapper userMapper;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUserByName() {
        // 假设 User 类有一个名为 name 的字段
        User expectedUser = new User();
        expectedUser.setName("张三");

        // 配置模拟对象返回预期值
        when(userMapper.selectOne(any())).thenReturn(expectedUser);

        // 执行测试方法
        User result = userMapper.selectOne(new QueryWrapper<User>().eq("name", "张三"));

        // 验证结果
        assert result.getName().equals("张三") : "查询的用户不是张三";

        // 验证交互行为
        verify(userMapper).selectOne(any());
    }
}