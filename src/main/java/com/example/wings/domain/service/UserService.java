package com.example.wings.domain.service;

import com.example.wings.domain.beans.User;
import com.example.wings.domain.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @description
 * @date 2020/11/17
 */
@Service
@AllArgsConstructor
public class UserService {

    private UserMapper userMapper;

    public List<User> list(){
        return userMapper.selectAll();
    }
}
