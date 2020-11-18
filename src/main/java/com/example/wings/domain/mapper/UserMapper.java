package com.example.wings.domain.mapper;

import com.example.wings.domain.beans.User;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author Administrator
 * @description
 * @date 2020/11/17
 */
@Repository
public interface UserMapper extends Mapper<User> {
}
