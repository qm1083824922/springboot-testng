package com.sailheader.testng.controller;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.entity.UserDept;
import com.sailheader.testng.service.UserDeptService;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import java.time.LocalDateTime;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

@SpringBootTest
@TestPropertySource(locations="classpath:application-test.yml")
public class UserControllerIntegrationTest extends AbstractTestNGSpringContextTests {

    @Autowired
    private UserService userService;
    @Autowired
    private UserDeptService userDeptService;

    @Autowired
    private UserController userController;

    @Test
    @Transactional(rollbackFor = Exception.class)
    public void testGetUser() {
        // Assuming there is a user with ID 1 in the database
        User user = new User();
        user.setId(32L).setName("关羽")
                .setAge(40)
                .setCreateUser(1L)
                .setUpdateUser(1L)
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        user.setEmail("guanyu@example.com");
        userService.save(user);
        UserDept userDept = new UserDept();
        long userDeptId = IdWorker.getId();
        userDept.setId(userDeptId)
                .setUserId(32L)
                .setDeptId(1L)
                .setCreateBy("admin")
                .setUpdateBy("admin")
                .setCreateTime(LocalDateTime.now())
                .setUpdateTime(LocalDateTime.now());
        userDeptService.save(userDept);


        // Calling the getUser() method of UserController
        UserVO actualUserVO = userController.getUser(32L);

        // Asserting the result
        assertNotNull(actualUserVO);
        assertEquals(actualUserVO.getId(), user.getId());
        assertEquals(actualUserVO.getName(), user.getName());
        assertEquals(actualUserVO.getEmail(), user.getEmail());
    }
}
