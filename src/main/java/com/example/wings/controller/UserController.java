package com.example.wings.controller;

import com.example.wings.domain.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Administrator
 * @description
 * @date 2020/11/17
 */
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService userService;

    @RequestMapping("/list")
    public Object query(){
        return userService.list();
    }

}
