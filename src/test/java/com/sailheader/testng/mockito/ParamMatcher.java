package com.sailheader.testng.mockito;

import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

/**
 * 参数匹配：通过方法签名(参数)来指定哪些方法调用需要被处理(插桩、verify验证)
 *
 */
@ExtendWith(MockitoExtension.class)
public class ParamMatcher {

    @Mock
    private UserService mockUserService;

    /**
     * 对于Mock对象不会调用真实方法，直接返回Mock对象默认值
     * 默认值(int)、null(userVO)、空集合(List)
     */
    @Test
    public void test1(){
        //null
        UserVO userVO = mockUserService.getUserById(1L);
        System.out.println("userVO = " + userVO);
        UserDTO userDTO = new UserDTO();
        // false
        Boolean flag = mockUserService.updateUser(userDTO);
    }

    /**
     * 测试插桩时的参数匹配,只拦截userDTO1
     */
    @Test
    public void test2(){
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1L);
        //指定参数为userDTO调用mockUserService.updateUser返回true
        Mockito.doReturn(true).when(mockUserService.updateUser(userDTO1));
        Boolean flag1 = mockUserService.updateUser(userDTO1);
        Boolean flag2 = mockUserService.updateUser(userDTO1);
        Assert.assertTrue(flag1);
        Assert.assertTrue(flag2);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(2L);
        Boolean flag3 = mockUserService.updateUser(userDTO1);
    }

    /**
     * 测试插桩时的参数匹配,ArgumentMatchers.any拦截UserDTO任意对象
     * 除了any还有anyXX，注意它们都不包括null
     */
    @Test
    public void test3(){
        UserDTO userDTO1 = new UserDTO();
        userDTO1.setId(1L);
        //指定参数为userDTO调用mockUserService.updateUser返回true
        Mockito.doReturn(true).when(mockUserService.updateUser(ArgumentMatchers.any(UserDTO.class)));
        Boolean flag1 = mockUserService.updateUser(userDTO1);
        Boolean flag2 = mockUserService.updateUser(userDTO1);
        Assert.assertTrue(flag1);
        Assert.assertTrue(flag2);

        UserDTO userDTO2 = new UserDTO();
        userDTO2.setId(2L);
        Boolean flag3 = mockUserService.updateUser(userDTO1);
    }

    @Test
    public void test4(){
        List<String> features = new ArrayList<>();
        mockUserService.add("zhangSan",18,features);
        //指定参数为userDTO调用mockUserService.updateUser返回true

        Mockito.verify(mockUserService,Mockito.times(1)).add("zhangSan",18,features);
        // when using matchers all arguments have to be provided by matchers
        //Mockito.verify(mockUserService,Mockito.times(1)).add(anyString(),18,features);
        Mockito.verify(mockUserService,Mockito.times(1)).add(anyString(),anyInt(),anyList());
    }
}
