package vn.edu.nha.TruyenDuLieuSangView.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String trangChu(Model model) {
        model.addAttribute("mssv", "64133131");
        model.addAttribute("hoTen", "Nguyen Thanh Nha");
        model.addAttribute("ngaySinh", "03/01/2004");
        model.addAttribute("gioiTinh", "Nam");

        return "index";
    }
}
