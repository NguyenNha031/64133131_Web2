package thigk.ntu64133131.nguyenthanhnha_baithigk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Controller
public class HomeController {

    @GetMapping("/")
    public String redirectToSBAdmin() {
        return "indexSB";
    }
    @GetMapping("/studentList")
    public String listPage(Model model) {
//        model.addAttribute("dsSV", dsSV);
//        model.addAttribute("sinhVien", new SinhVien());
        return "fragments/studentList";
    }
    @GetMapping("/homepage")
    public String home1() {
        return "fragments/contentSB";
    }
    @GetMapping("/address")
    public String addressPage() {
        return "fragments/address";
    }
}