package com.klbc.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.klbc.blog.entity.Article;

/**
 * 文章表(Article)表服务接口
 *
 * @author klbc
 */
public interface ArticleService extends IService<Article> {

  /**
   * 提取Summary
   *
   * @param content
   * @return
   */
  String extractSummaryHandle(String content);
}
