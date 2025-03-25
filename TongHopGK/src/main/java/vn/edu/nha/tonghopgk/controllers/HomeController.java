package vn.edu.nha.tonghopgk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    List<SinhVien> dsSV = new ArrayList<>();

    public HomeController() {
        dsSV.add(new SinhVien("001", "Nguyễn Thanh Nhàx", 1.5));
        dsSV.add(new SinhVien("002", "Tguyễn Thị Bình", 7.5));
        dsSV.add(new SinhVien("003", "Bình Văn trương", 6.8));
    }
    @GetMapping("/studentList")
    public String listPage(Model model) {
        model.addAttribute("dsSV", dsSV);
        return "studentList";
    }

    @GetMapping("/homepage")
    public String home() {
        return "index";
    }

    @GetMapping("/about")
    public String aboutPage() {
        return "about";
    }

    @GetMapping("/address")
    public String addressPage() {
        return "address";
    }
}
