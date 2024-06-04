package com.sailheader.testng.mockito;

import com.sailheader.testng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.annotations.BeforeClass;

@ExtendWith(MockitoExtension.class)
public class InitMockOrSpyMethod3 {
    @Mock
    UserService mockUserService;
    @Spy
    UserService spyUserService;

    @BeforeClass
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test1(){
        //判断某对象是不是Mock对象,
        System.out.println("Mockito.mockingDetails(mockUserService).isMock() = " + Mockito.mockingDetails(mockUserService).isMock());
        System.out.println("Mockito.mockingDetails(spyUserService).isSpy() = " + Mockito.mockingDetails(spyUserService).isSpy());
    }
}
