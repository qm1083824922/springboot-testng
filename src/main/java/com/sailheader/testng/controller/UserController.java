package com.sailheader.testng.controller;

import com.sailheader.testng.entity.User;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户接口
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

}
