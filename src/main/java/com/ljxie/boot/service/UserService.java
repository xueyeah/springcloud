package com.ljxie.boot.service;

import com.github.pagehelper.PageHelper;
import com.ljxie.boot.domain.mapper.ex.UserExMapper;
import com.ljxie.boot.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService {
    @Autowired
    private UserExMapper userMapper;

    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }
}
