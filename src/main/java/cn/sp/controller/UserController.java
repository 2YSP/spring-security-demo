package cn.sp.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * @Author: 2YSP
 * @Description: 登录信息验证成功会请求这个controller
 * @Date: Created in 2018/1/12
 */
@Controller
public class UserController {

    @GetMapping("/user")
    public String user(@AuthenticationPrincipal Principal principal, ModelMap model){
        model.addAttribute("username",principal.getName());
        return "user/user";
    }
}
