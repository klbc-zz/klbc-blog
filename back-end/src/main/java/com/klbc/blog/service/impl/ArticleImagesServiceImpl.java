package com.klbc.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klbc.blog.entity.ArticleImages;
import com.klbc.blog.mapper.ArticleImagesMapper;
import com.klbc.blog.service.ArticleImagesService;
import org.springframework.stereotype.Service;

/**
 * (ArticleImages)表服务实现类
 *
 * @author klbc
 */
@Service("articleImagesService")
public class ArticleImagesServiceImpl extends ServiceImpl<ArticleImagesMapper, ArticleImages>
    implements ArticleImagesService {}
