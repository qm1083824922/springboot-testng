package com.sailheader.testng.mockito;

import com.sailheader.testng.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockingDetails;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * mockito
 * ito: input to output
 * 原理：bytebuddy,通过修改字节码来完成的
 */
@ExtendWith(MockitoExtension.class)
@Slf4j
public class InitMockOrSpyMethod1 {

    @Mock
    UserService mockUserService;
    @Spy
    UserService spyUserService;

    /**
     * 测试spy与mock
     *
     */
    @Test
    public void test1(){
        //判断某对象是不是Mock对象,
        log.info("Mockito.mockingDetails(mockUserService).isMock() ={}",Mockito.mockingDetails(mockUserService).isMock());
        log.info("Mockito.mockingDetails(spyUserService).isSpy() = {}",Mockito.mockingDetails(spyUserService).isSpy());
    }

}
