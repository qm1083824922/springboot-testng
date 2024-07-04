package com.sailheader.testng.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sailheader.testng.entity.User;
import io.micrometer.common.util.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Field;

import static org.mockito.Mockito.*;

public class UserMapperTest {

    @Mock
    private UserMapper userMapper;

    @BeforeClass
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindUserByName() {
        // 假设 User 类有一个名为 name 的字段
        User expectedUser = new User();
        expectedUser.setName("张三");

        // 配置模拟对象返回预期值
        when(userMapper.selectOne(any())).thenReturn(expectedUser);

        // 执行测试方法
        User result = userMapper.selectOne(new QueryWrapper<User>().eq("name", "张三"));

        // 验证结果
        assert result.getName().equals("张三") : "查询的用户不是张三";

        // 验证交互行为
        verify(userMapper).selectOne(any());
    }

    /**
     *
     */
    @Test
    public void testSequence() {
        String sequenceNumber = "4061200000001";
        String componentSns = ",4061200000001,4061200000001-1,4061200000001-2,";


        // Step 1: Remove leading and trailing commas
        componentSns = componentSns.trim().replaceAll("^,|,$", "");

        // Step 2: Split the string by comma to handle individual components
        String[] components = componentSns.split(",");

        // Step 3: Use StringBuilder to construct the new string
        StringBuilder result = new StringBuilder();
        for (String component : components) {
            if (!component.equals(sequenceNumber)) {
                if (!result.isEmpty()) {
                    result.append(",");
                }
                result.append(component);
            }
        }

        // Output the result
        System.out.println(result.toString());
    }


    @Test
    public void testSequence1() {
        String sequenceNumber = "4061200000001";
        String componentSns = ",4061200000001,4061200000001-1,4061200000001-2,";

        // Step 1: Remove leading and trailing commas
        componentSns = componentSns.trim().replaceAll("^,|,$", "")
                .replaceAll("(^|,)" + sequenceNumber + "(,|$)", "$1$2")
                .replaceAll("^,|,$", "");

        // Output the result
        System.out.println(componentSns);
    }

    @Test
    public void checkPcmVersionAndBomVersion(String customizedFields) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(customizedFields);



        String pcbVersion = jsonNode.path("BB_wo").asText(null);
        String bomVersion = jsonNode.path("BMBB_wo").asText(null);

        // 1. Check if either BB_wo or BMBB_wo is empty
        if (StringUtils.isBlank(pcbVersion) && StringUtils.isBlank(bomVersion)) {
            System.out.println("PCB版本和BOM版本至少需要填写一项，请填写后再生成标签！");
        }

        // 2. Validate that BB_wo only contains letters or digits
        if (StringUtils.isNotBlank(pcbVersion) && !pcbVersion.matches("[a-zA-Z0-9]+")) {
            System.out.println("PCB版号只能填写字母或数字，请重新输入！");
        }
    }



}