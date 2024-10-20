package com.sailheader.testng.controller;

import com.sailheader.testng.common.Result;
import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import com.sailheader.testng.vo.req.UserRegisterVo;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户接口
 * @Valid 注解用于校验请求参数
 * @Validated 注解用于校验请求参数,支持分组校验
 * @since 2024/10/20 11:08
 */
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserController {
    UserService userService;

    @GetMapping("/{id}")
    public UserVO getUser(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
    @PostMapping("/addUser")
    public Boolean addUser(UserDTO userDTO) {
        return userService.addUser(userDTO);
    }

    @GetMapping("/updateUser")
    public Boolean updateUser(UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @PostMapping("/addUserList")
    public Boolean addUserList(List<UserDTO> userDTOList) {
        return userService.submit(userDTOList);
    }

    /**
     * 用户注册
     * @param userRegisterVo 用户注册信息
     * @return 注册结果
     */
    @PostMapping("/register")
    public Result<String> register(@Valid @RequestBody UserRegisterVo userRegisterVo) {
        userService.register(userRegisterVo);
        return Result.success("注册成功");

    }
}
