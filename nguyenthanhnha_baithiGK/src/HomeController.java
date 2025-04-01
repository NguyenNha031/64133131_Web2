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
}
    @GetMapping("/")
    public String redirectToSBAdmin() {
     return "indexSB";
}
}