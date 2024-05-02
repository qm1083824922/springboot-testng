package com.sailheader.testng.mapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sailheader.testng.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.testng.annotations.Test;

@SpringBootTest
@ActiveProfiles("test") // 指定使用测试配置文件，例如 application-test.yml
public class UserMapperIntegrationTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testFindUserByName() {
        // 执行真实查询
        User result = userMapper.selectOne(new QueryWrapper<User>().eq("name", "张三"));

        // 验证结果
        assert result != null && "张三".equals(result.getName()) : "查询的用户不是张三";
    }
}
