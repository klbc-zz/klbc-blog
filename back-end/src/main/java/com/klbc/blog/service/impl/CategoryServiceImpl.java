package com.klbc.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klbc.blog.mapper.CategoryMapper;
import com.klbc.blog.entity.Category;
import com.klbc.blog.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * 类别表(Category)表服务实现类
 *
 * @author klbc
 */
@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper,Category> implements CategoryService {
}
