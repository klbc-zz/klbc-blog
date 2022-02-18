package com.klbc.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.klbc.blog.entity.User;
import com.klbc.blog.jwt.JwtUtils;
import com.klbc.blog.service.UserService;
import com.klbc.blog.util.R;
import com.klbc.blog.vo.LoginVO;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

/**
 * TODO
 *
 * @author klbc
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
  @Autowired
  private BCryptPasswordEncoder encoder;
  @Autowired private UserService userService;


  @PostMapping("/login")
  public R<LoginVO> login(@Validated @RequestBody User user) {
    // 对 html 标签进行转义，防止 XSS 攻击
//    String username = user.getUsername();
//    username = HtmlUtils.htmlEscape(username);


    if (userService.userLogin(user)) {
      LoginVO loginVO = new LoginVO();
      loginVO.setUsername(user.getUsername());
      loginVO.setToken(JwtUtils.genToken(user));
      return R.success(loginVO);
    }
    return R.fail();
  }
}
