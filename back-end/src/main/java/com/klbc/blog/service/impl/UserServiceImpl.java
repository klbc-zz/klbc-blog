package com.klbc.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klbc.blog.entity.User;
import com.klbc.blog.mapper.UserMapper;
import com.klbc.blog.service.UserService;
import com.klbc.blog.util.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder encoder;//密码加密
    /**
     * 验证用户登录
     * @param user
     * @return
     */

    @Override
    public boolean userLogin(User user) {
        QueryWrapper selectQuery=new QueryWrapper();
        selectQuery.eq("username",user.getUsername());
        User userregister = userMapper.selectOne(selectQuery);
//        userregister.getPassword().equals(user.getPassword())
        if(userregister == null){ return false; }
        if (! encoder.matches(user.getPassword(),userregister.getPassword())){
            return false;
        }
        return true;
    }
}
