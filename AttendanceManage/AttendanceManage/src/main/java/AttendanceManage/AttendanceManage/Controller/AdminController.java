package AttendanceManage.AttendanceManage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AttendanceManage.AttendanceManage.Model.Admin;
import AttendanceManage.AttendanceManage.Service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/list")
    public String viewAdminList(Model model) {
        model.addAttribute("admins", adminService.getAllAdmins());
        return "admin/adminList";
    }

    @GetMapping("/add")
    public String addAdminForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin/addAdmin";
    }

    @PostMapping("/save")
    public String saveAdmin(@ModelAttribute("admin") Admin admin) {
        adminService.saveAdmin(admin);
        return "redirect:/admin/list";
    }
    @GetMapping("/edit")
    public String updateAdmin(@ModelAttribute("admin") Admin admin) {
    	System.out.println(admin);
    	adminService.saveAdmin(admin);
    	return "redirect:/admin/list";
    }

    @GetMapping("/edit/{id}")
    public String editAdminForm(@PathVariable Long id, Model model) {
        model.addAttribute("admin", adminService.getAdminById(id));
        return "admin/updateAdmin";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/list";
    }
}
