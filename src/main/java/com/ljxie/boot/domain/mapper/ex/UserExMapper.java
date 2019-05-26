package com.ljxie.boot.domain.mapper.ex;

import com.ljxie.boot.domain.mapper.UserMapper;
import com.ljxie.boot.domain.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserExMapper extends UserMapper{
    List<User> selectAllUser();

}