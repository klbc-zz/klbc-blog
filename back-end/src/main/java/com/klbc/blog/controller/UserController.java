package com.klbc.blog.controller;

import com.klbc.blog.entity.User;
import com.klbc.blog.jwt.JwtUtils;
import com.klbc.blog.util.R;
import com.klbc.blog.vo.LoginVO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author klbc
 */
@RestController
@RequestMapping("/user")
public class UserController {
  @PostMapping("/login")
  public R<LoginVO> login(@Validated @RequestBody User user) {

    if (user.getUsername().equals("noodzhan") && user.getPassword().equals("noodzhan")) {
      LoginVO loginVO = new LoginVO();
      loginVO.setUsername("noodzhan");
      loginVO.setToken(JwtUtils.genToken(user));
      return R.success(loginVO);
    }
    return R.fail();
  }
}
