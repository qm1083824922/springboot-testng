package com.sailheader.testng.controller;

import com.sailheader.testng.dto.UserDTO;
import com.sailheader.testng.entity.User;
import com.sailheader.testng.service.UserService;
import com.sailheader.testng.vo.UserVO;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
