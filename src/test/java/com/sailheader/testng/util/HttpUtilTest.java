package com.sailheader.testng.util;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.testng.Assert.*;

public class HttpUtilTest {

    /**
     * 测试静态方法
     */
    @Test
    public void testDoPost() {
        //用完后关闭，避免影响其他测试用例
        try(MockedStatic<HttpUtil> httpUtilMocked = Mockito.mockStatic(HttpUtil.class)) {
            httpUtilMocked.when(() -> HttpUtil.doPost(anyString(), anyString())).thenReturn("success");
            String result = HttpUtil.doPost("http://www.baidu.com", "hello");
            assertEquals(result, "success");
        }
        //mockStatic关闭之后，再次调用，结果就没有被mock了
        //String result = HttpUtil.doPost("http://www.baidu.com", "hello");
        //Assert.assertEquals("第三方系统返回的结果：", result);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            System.out.println(IdWorker.getId());
        }
    }
}