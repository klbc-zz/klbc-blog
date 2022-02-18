package com.klbc.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.klbc.blog.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author klbc
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
