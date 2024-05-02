package com.sailheader.testng.junit5;

import com.sailheader.testng.TestngApplication;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@SpringBootTest
public class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    public void testGetById() {
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
