package com.klbc.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klbc.blog.entity.User;
import com.klbc.blog.util.R;

public interface UserService extends IService<User> {
    public  boolean userLogin(User user);
}
