package vn.edu.nha.tonghopgk.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    List<SinhVien> dsSV = new ArrayList<>();

    public HomeController() {
        dsSV.add(new SinhVien("001", "Nguyễn Thanh Nhã", 1.5));
        dsSV.add(new SinhVien("002", "Nguyễn Thị Bình", 7.5));
        dsSV.add(new SinhVien("003", "Bình Văn Trương", 6.8));
    }

    @GetMapping("/studentList")
    public String listPage(Model model) {
        model.addAttribute("dsSV", dsSV);
        return "fragments/studentList";
    }

    // Hiển thị form thêm sinh viên
    @GetMapping("/addStudent")
    public String showAddForm(Model model) {
        model.addAttribute("sinhVien", new SinhVien());
        return "fragments/addStudentForm";
    }

    // Xử lý thêm sinh viên
    @PostMapping("/addStudent")
    public String addStudent(@ModelAttribute SinhVien sinhVien) {
        // Tạo MSSV mới tự động tăng
        String newMssv = String.format("%03d", dsSV.size() + 1);
        sinhVien.setMssv(newMssv);
        dsSV.add(sinhVien);
        return "redirect:/studentList";
    }

    // Hiển thị form sửa sinh viên
    @GetMapping("/editStudent/{mssv}")
    public String showEditForm(@PathVariable String mssv, Model model) {
        Optional<SinhVien> sinhVien = dsSV.stream()
                .filter(sv -> sv.getMssv().equals(mssv))
                .findFirst();

        if (sinhVien.isPresent()) {
            model.addAttribute("sinhVien", sinhVien.get());
            return "fragments/editStudentForm";
        } else {
            return "redirect:/studentList";
        }
    }

    // Xử lý sửa sinh viên
    @PostMapping("/editStudent")
    public String editStudent(@ModelAttribute SinhVien sinhVien) {
        for (int i = 0; i < dsSV.size(); i++) {
            if (dsSV.get(i).getMssv().equals(sinhVien.getMssv())) {
                // Giữ nguyên MSSV, chỉ cập nhật thông tin khác
                dsSV.set(i, new SinhVien(
                        sinhVien.getMssv(),
                        sinhVien.getHoTen(),
                        sinhVien.getDiemTb()
                ));
                break;
            }
        }
        return "redirect:/studentList";
    }

    // Xử lý xóa sinh viên
    @GetMapping("/deleteStudent/{mssv}")
    public String deleteStudent(@PathVariable String mssv) {
        dsSV.removeIf(sv -> sv.getMssv().equals(mssv));
        return "redirect:/studentList";
    }


    @GetMapping("/")
    public String redirectToSBAdmin() {
        return "indexSB";
    }

    @GetMapping("/homepage")
    public String home1() {
        return "fragments/contentSB";
    }

    @GetMapping("/about")
    public String aboutPage(Model model) {
        model.addAttribute("ten", "Nguyễn Thanh Nhã");
        model.addAttribute("lop", "64.CNTT-CLC");
        model.addAttribute("namSinh", "03/01/2004");
        model.addAttribute("chieuCao", "1m9");
        model.addAttribute("canNang", "90kg");
        model.addAttribute("diaChi", "Hải Thủy, Cam Phúc Nam, Cam Ranh, Khánh Hòa");
        return "fragments/about"; // Trả về fragment about.html
    }


    @GetMapping("/address")
    public String addressPage() {
        return "fragments/address";
    }
}