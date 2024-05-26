package com.sailheader.testng.controller;

import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.testng.Assert.*;

public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUser() {
        // Mocking the behavior of userService.getUserById() method
        UserVO expectedUserVO = new UserVO();
        expectedUserVO.setId(1L);
        expectedUserVO.setName("John Doe");
        expectedUserVO.setEmail("john@example.com");

        when(userService.getUserById(anyLong())).thenReturn(expectedUserVO);

        // Calling the getUser() method of UserController
        UserVO actualUserVO = userController.getUser(1L);

        // Asserting the result
        assertNotNull(actualUserVO);
        assertEquals(actualUserVO.getId(), expectedUserVO.getId());
        assertEquals(actualUserVO.getName(), expectedUserVO.getName());
        assertEquals(actualUserVO.getEmail(), expectedUserVO.getEmail());
    }
}