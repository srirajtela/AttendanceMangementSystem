package AttendanceManage.AttendanceManage.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "home"; // Points to src/main/resources/templates/home.html
    }
}

