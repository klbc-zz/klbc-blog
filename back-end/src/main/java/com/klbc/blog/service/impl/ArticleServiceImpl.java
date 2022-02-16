package com.klbc.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.klbc.blog.entity.Article;
import com.klbc.blog.mapper.ArticleMapper;
import com.klbc.blog.service.ArticleService;
import org.springframework.stereotype.Service;

/**
 * 文章表(Article)表服务实现类
 *
 * @author klbc
 */
@Service("articleService")
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article>
    implements ArticleService {
  @Override
  public String extractSummaryHandle(String content) {
    return content.substring(0, Math.min(content.length(), 250)).replace('#', ' ').replace('*', ' ')
        + "...";
  }
}
