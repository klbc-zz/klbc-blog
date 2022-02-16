package com.klbc.blog.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.klbc.blog.constant.NoodbConstant;
import com.klbc.blog.entity.Article;
import com.klbc.blog.entity.ArticleImages;
import com.klbc.blog.service.ArticleImagesService;
import com.klbc.blog.service.ArticleService;
import com.klbc.blog.util.FileUtils;
import com.klbc.blog.util.R;
import com.klbc.blog.vo.UploadImageVO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 博客的增删改查接口
 *
 * @author klbc
 */
@RestController
@RequestMapping("/article")
public class BlogController {
  @Autowired private ArticleService articleService;
  @Autowired private ArticleImagesService articleImagesService;

  @Value("${article.imagePath}")
  private String filePath;

  @GetMapping("/all")
  public R<Page> findAllArticleByPage(
      @RequestParam("pageNum") Integer pageNum,
      @RequestParam(value = "pageSize", defaultValue = "15") Integer pageSize,
      @RequestParam(value = "searchValue", required = false) String searchValue) {
    Page<Article> articlePage = new Page<>(pageNum, pageSize);
    articleService
        .lambdaQuery()
        .like(
            Strings.isNotBlank(searchValue),
            Article::getTitle,
            NoodbConstant.percentChar + searchValue + NoodbConstant.percentChar)
        .select(Article::getId, Article::getTitle, Article::getSummary)
        .page(articlePage);
    return R.success(articlePage);
  }

  @GetMapping("/one")
  public R<Article> findArticleById(@RequestParam("id") Long id) {
    return R.success(articleService.lambdaQuery().eq(Article::getId, id).one());
  }

  @PostMapping("/edit")
  public R<String> editOrInsertArticle(@RequestBody @Validated Article article) {
    article.setSummary(articleService.extractSummaryHandle(article.getContent()));
    articleService.saveOrUpdate(article);
    return R.success(article.getId().toString());
  }

  @PostMapping("/delete")
  public R<Boolean> deleteArticleByIds(@RequestBody List<String> ids) {
    return R.success(articleService.removeByIds(ids));
  }

  @PostMapping("/img")
  public R<UploadImageVO> uploadImage(
      @RequestPart("file") MultipartFile file,
      @RequestPart("articleImages") ArticleImages articleImages) {
    UploadImageVO result = new UploadImageVO();
    BeanUtils.copyProperties(articleImages, result);
    String absoluteFileName = FileUtils.generateFileByMultipartFile(file, filePath);
    result.setImageName(FileUtils.getFileNameFromAbsolutePath(absoluteFileName));
    result.setImageType(file.getContentType());
    result.setSystemUrl(absoluteFileName);
    result.setFrontUrl(
        NoodbConstant.resourceUrlPrefix + FileUtils.getFileNameFromAbsolutePath(absoluteFileName));
    articleImagesService.save(result);
    return R.success(result);
  }
}
