package cn.sp.controller;

import cn.sp.entity.User;
import cn.sp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @Author: 2YSP
 * @Description:
 * @Date: Created in 2018/1/12
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping({"/","/index","/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String doRegister(User user){
        // 此处省略校验逻辑
        if (userService.insert(user)){
            return "redirect:register?success";
        }

        return "redirect:register?error";
    }
}
