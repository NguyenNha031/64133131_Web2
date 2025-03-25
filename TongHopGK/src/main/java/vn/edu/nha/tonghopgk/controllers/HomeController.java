package vn.edu.nha.tonghopgk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/homepage")
    public String home() {
        return "index";
    }
    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/list")
    public String listPage() {
        return "list";
    }

    @GetMapping("/address")
    public String addressPage() {
        return "address";
    }
}