package com.sailheader.testng;

import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import static org.testng.Assert.assertEquals;

@SpringBootTest
class TestngApplicationTests{

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void getById() {
        // Setup
        final UserVO expectedResult = new UserVO();
        expectedResult.setId(1L);
        expectedResult.setName("张三");
        expectedResult.setAge(20);
        expectedResult.setEmail("zhangsan@example.com");

        // Run the test
        final UserVO userVO = userService.getUserById(1L);

        // Verify the results
        assertEquals(expectedResult.getName(), userVO.getName());
    }

}
