package com.sailheader.testng.spring;

import com.sailheader.testng.TestngApplication;
import com.sailheader.testng.entity.Dept;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.mapper.DeptMapper;
import com.sailheader.testng.mapper.UserMapper;
import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.service.impl.UserServiceImpl;
import com.sailheader.testng.vo.UserVO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

/**
 * InjectMocks不能注入父类的属性
 */
@SpringBootTest(classes = TestngApplication.class)
public class UserServiceImplInSpringTest {

    @Resource
    @SpyBean
    private UserServiceImpl userService;

    @MockBean
    private DeptService deptService;

    @MockBean
    private UserMapper userMapper;

    @MockBean
    private DeptMapper deptMapper;

    @SpyBean
    private DataSourceProperties dataSourceProperties;

    @BeforeMethod
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetUserById2() {
        System.out.println(dataSourceProperties);
        //doReturn(userMapper).when(userService).getBaseMapper();
        UserVO userVO = userService.getUserById(1L);
        Assertions.assertNull(userVO);
    }

    @Test
    public void testGetUserById3() {

        //doReturn(userMapper).when(userService).getBaseMapper();
        //配置方法getUserById返回值
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("John");
        doReturn(user).when(userService).getUserById(userId);
        //执行测试
        UserVO userVO = userService.getUserById(1L);
        //断言
        Assertions.assertNotNull(userVO);
    }

    @Test
    public void testGetUserById4() {
        //配置方法getUserById返回值
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("John");
        doReturn(user).when(userService).getUserById(userId);

        List<Dept> deptList = new ArrayList<>();
        Dept dept1 = new Dept();
        dept1.setId(1L);
        dept1.setName("Dept1");
        Dept dept2 = new Dept();
        dept2.setId(2L);
        dept2.setName("Dept2");
        deptList.add(dept1);
        deptList.add(dept2);
        doReturn(deptList).when(deptService).getDeptByUserId(1L);

        //执行测试
        UserVO userVO = userService.getUserById(1L);

        //断言
        Assertions.assertEquals("1",userVO.getDeptId());
    }

    @Test
    public void testGetUserById1() {

        // Mocking data
        Long userId = 1L;
        User user = new User();
        user.setId(userId);
        user.setName("John");
        // Mocking userMapper.getById()
        when(userMapper.selectById(userId)).thenReturn(user);

        // Mocking deptService.getDeptByUserId()
        List<Dept> deptList = new ArrayList<>();
        Dept dept1 = new Dept();
        dept1.setId(1L);
        dept1.setName("Dept1");
        Dept dept2 = new Dept();
        dept2.setId(2L);
        dept2.setName("Dept2");
        deptList.add(dept1);
        deptList.add(dept2);
        when(deptService.getDeptByUserId(userId)).thenReturn(deptList);

        // Call the method
        UserVO userVO = userService.getUserById(userId);

        // Assertions
        assertNotNull(userVO);
        assertEquals(userVO.getId(), user.getId());
        assertEquals(userVO.getName(), user.getName());
        assertEquals(userVO.getDeptId(), "1,2"); // Assuming dept ids are concatenated with commas
        assertEquals(userVO.getDeptName(), "Dept1,Dept2"); // Assuming dept names are concatenated with commas
    }
}
