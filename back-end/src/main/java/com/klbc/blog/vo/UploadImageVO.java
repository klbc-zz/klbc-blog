package com.klbc.blog.vo;

import com.klbc.blog.entity.ArticleImages;

/**
 * TODO
 *
 * @author klbc
 */
public class UploadImageVO extends ArticleImages {
  private String frontUrl;

  public String getFrontUrl() {
    return frontUrl;
  }

  public void setFrontUrl(String frontUrl) {
    this.frontUrl = frontUrl;
  }
}
