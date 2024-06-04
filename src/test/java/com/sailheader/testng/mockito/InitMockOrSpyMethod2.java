package com.sailheader.testng.mockito;

import com.sailheader.testng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.BeforeClass;

@ExtendWith(MockitoExtension.class)
@Slf4j
public class InitMockOrSpyMethod2 {

    @Mock
    UserService mockUserService;
    @Spy
    UserService spyUserService;

    @BeforeClass
    public void init(){
        mockUserService = Mockito.mock(UserService.class);
        spyUserService = Mockito.mock(UserService.class);
    }

    @Test
    public void test1(){
        //判断某对象是不是Mock对象,
        System.out.println("Mockito.mockingDetails(mockUserService).isMock() = " + Mockito.mockingDetails(mockUserService).isMock());
        System.out.println("Mockito.mockingDetails(spyUserService).isSpy() = " + Mockito.mockingDetails(spyUserService).isSpy());
    }
}
