package com.sailheader.testng.mockito;

import com.sailheader.testng.service.DeptService;
import com.sailheader.testng.service.impl.UserServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

/**
 * 插桩测试
 */
@ExtendWith(MockitoExtension.class)
public class StubTest {

    @Mock
    List<String> mockList;

    @Mock
    UserServiceImpl userServiceImpl;

    @Mock
    DeptService deptService;

    @Spy
    UserServiceImpl spyUserService;

    @BeforeClass
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void test1(){
        //方法一：
        Mockito.doReturn("zero").when(mockList).get(0);
        //如果返回值不相等，单元测试会失败
        Assert.assertEquals("zero",mockList.get(0));
    }

    @Test
    public void test2(){
        Mockito.when(mockList.get(1)).thenReturn("one");
        Assert.assertEquals("one", mockList.get(1));
    }

    /**
     * void方法返回值插桩
     */
    @Test
    public void test3(){
        Mockito.doNothing().when(mockList).clear();
        mockList.clear();
        Mockito.verify(mockList,Mockito.times(1)).clear();
    }

    @Test
    public void test4(){
        int i = userServiceImpl.getNumber();
        Mockito.when(userServiceImpl.getNumber()).thenReturn(99);
        //userServiceImpl.getNumber() = 99
        System.out.println("userServiceImpl.getNumber() = " + userServiceImpl.getNumber());


        Mockito.when(spyUserService.getNumber()).thenReturn(99);
        //spyUserService.getNumber() =
        //spy默认没有插桩时是执行真实方法，写在when中会导致先执行一次原方法，达不到Mock的目的
        //需要使用doXXX.when().someMethods()
        System.out.println("spyUserService.getNumber() = " + spyUserService.getNumber());

        //推荐使用这种方式
        Mockito.doReturn(1000).when(spyUserService).getNumber();
        System.out.println("spyUserService.getNumber() = " + spyUserService.getNumber());

    }

    /**
     * 抛出异常
     */
    @Test
    public void test5(){
        //方法一：
        doThrow(RuntimeException.class).when(mockList).get(anyInt());
        try {
            mockList.get(4);
            //插桩失败了
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
        }

    }

    @Test
    public void test6(){
        //方法一：
        doThrow(RuntimeException.class).when(mockList).clear();
        try {
            mockList.clear();
            //插桩失败了
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
        }

        when(mockList.get(anyInt())).thenThrow(RuntimeException.class);
        try {
            mockList.get(4);
            //插桩失败了
            Assert.fail();
        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
        }

    }

}
