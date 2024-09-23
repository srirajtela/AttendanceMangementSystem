package AttendanceManage.AttendanceManage.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import AttendanceManage.AttendanceManage.Model.Faculty;
import AttendanceManage.AttendanceManage.Service.FacultyService;

@Controller
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // View all faculty members
    @GetMapping("/list")
    public String viewFacultyList(Model model) {
        model.addAttribute("faculties", facultyService.getAllFaculties());
        return "faculty/facultyList";
    }

    // Form to add a new faculty member
    @GetMapping("/add")
    public String addFacultyForm(Model model) {
        model.addAttribute("faculty", new Faculty());
        return "faculty/addFaculty";
    }

    // Save the new faculty member
    @PostMapping("/save")
    public String saveFaculty(@ModelAttribute("faculty") Faculty faculty) {
        facultyService.saveFaculty(faculty);
        return "redirect:/faculty/list";
    }

    // Form to edit an existing faculty member
    @GetMapping("/edit/{id}")
    public String editFacultyForm(@PathVariable Long id, Model model) {
        model.addAttribute("faculty", facultyService.getFacultyById(id));
        return "faculty/updateFaculty";
    }

    // Update an existing faculty member
    @PostMapping("/update/{id}")
    public String updateFaculty(@PathVariable Long id, @ModelAttribute("faculty") Faculty faculty) {
        faculty.setId(id);
        facultyService.saveFaculty(faculty);
        return "redirect:/faculty/list";
    }

    // Delete a faculty member
    @GetMapping("/delete/{id}")
    public String deleteFaculty(@PathVariable Long id) {
        facultyService.deleteFaculty(id);
        return "redirect:/faculty/list";
    }
}
