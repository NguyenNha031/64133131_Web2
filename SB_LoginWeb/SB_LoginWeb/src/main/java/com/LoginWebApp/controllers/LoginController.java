package com.LoginWebApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // <-- Bổ sung @Controller
public class LoginController {

    @GetMapping("/")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("id") String id, 
                        @RequestParam("password") String password, 
                        Model model) {
        if ("admin".equals(id) && "1234".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
            return "home";
        } else {
            model.addAttribute("error", "Sai ID hoặc mật khẩu!");
            return "login";
        }
    }
}
