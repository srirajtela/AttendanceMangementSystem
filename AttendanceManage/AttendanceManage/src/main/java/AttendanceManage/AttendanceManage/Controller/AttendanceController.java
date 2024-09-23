package AttendanceManage.AttendanceManage.Controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AttendanceManage.AttendanceManage.Model.Attendance;
import AttendanceManage.AttendanceManage.Model.Student;
import AttendanceManage.AttendanceManage.Service.AttendanceService;
import AttendanceManage.AttendanceManage.Service.StudentService;
import AttendanceManage.AttendanceManage.dto.AttendanceEntry;
import AttendanceManage.AttendanceManage.dto.AttendanceForm;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	private AttendanceService attendanceService;

	@Autowired
	private StudentService studentService;

//	@GetMapping("/mark")
//	public String markAttendanceForm(Model model) {
//		List<Student> students = studentService.getAllStudents();
//		model.addAttribute("students", students);
//		model.addAttribute("date", LocalDate.now());
//		return "attendance/markAttendance";
//	}
	
	
	
	
	
	@GetMapping("/mark")
	public String markAttendanceForm(Model model) {
	    List<Student> students = studentService.getAllStudents();

	    // Create and initialize AttendanceForm
	    AttendanceForm attendanceForm = new AttendanceForm();
	    
	    // Map Student to AttendanceEntry and set present to false by default
	    List<AttendanceEntry> attendanceEntries = students.stream()
	            .map(student -> new AttendanceEntry(student.getId(), false,student.getName()))
	            .collect(Collectors.toList());

	    // Set attendance entries in attendanceForm
	    attendanceForm.setAttendanceEntries(attendanceEntries);

	    // Add attributes to the model
	    model.addAttribute("students", students); // Optional: for direct student info display if needed
	    model.addAttribute("attendanceForm", attendanceForm); // Add attendance form to model
	    model.addAttribute("date", LocalDate.now()); // Pass the current date
	    return "attendance/markAttendance";
	}

	
	
	
	
	
	

//    @PostMapping("/save")
//    public String saveAttendance(@RequestParam("id") Long studentId,
//                                 @RequestParam("present") boolean present) {
//    	LocalDate date =LocalDate.now();
//        Attendance attendance = attendanceService.getAttendanceByStudentAndDate(studentId, date);
//        if (attendance == null) {
//            attendance = new Attendance();
//            attendance.setStudent(studentService.getStudentById(studentId));
//            attendance.setDate(date);
//        }
//        attendance.setPresent(present);
//        attendanceService.saveAttendance(attendance);
//        return "redirect:/attendance/list";
//    }

//	@GetMapping("/save")
//	public String saveAttendance(@ModelAttribute  List<AttendanceEntry>s) {
//		
//		System.out.println(s);
//	    LocalDate date = LocalDate.now();
//
////	    for (AttendanceEntry entry : attendanceDTO.getAttendanceEntries()) {
////	        if (entry.getStudentId() != null) {
////	            Attendance attendance = attendanceService.getAttendanceByStudentAndDate(entry.getStudentId(), date);
////	            if (attendance == null) {
////	                attendance = new Attendance();
////	                attendance.setStudent(studentService.getStudentById(entry.getStudentId()));
////	                attendance.setDate(date);
////	            }
////	            attendance.setPresent(entry.isPresent());
////	            attendanceService.saveAttendance(attendance);
////	        }
////	    }
//	    return "redirect:/attendance/list";
//	}



	 @PostMapping("/save")
	    public String saveAttendance(@ModelAttribute("attendanceForm") AttendanceForm
	    		attendanceForm, Model model) {
	        List<AttendanceEntry> attendanceList = attendanceForm.getAttendanceEntries();
           System.out.println(attendanceList);
           
           
           
           LocalDate date = LocalDate.now();
           
           	    for (AttendanceEntry entry : attendanceForm.getAttendanceEntries()) {
           	        if (entry.getId() != null&&entry.isPresent()==true) {
           	            Attendance attendance = attendanceService.getAttendanceByStudentAndDate(entry.getId(), date);
           	            if (attendance == null) {
           	                attendance = new Attendance();
           	                attendance.setStudent(studentService.getStudentById(entry.getId()));
           	                attendance.setDate(date);
           	            }
           	            attendance.setPresent(entry.isPresent());
           	            attendanceService.saveAttendance(attendance);
           	            
           	        }}
           
           
           
	        return "redirect:/attendance/list"; // Redirect after saving
	    }


	


	@GetMapping("/select-date")
	public String showSelectDateForm() {
		return "attendance/selectDate"; // Path to the selectDate.html template
	}

	@GetMapping
	public String getAttendanceByDate(
			@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date, Model model) {
		// Your code to handle attendance retrieval by date
		List<Attendance> attendanceList = attendanceService.getAttendanceByDate(date);
		model.addAttribute("attendanceList", attendanceList);
		return "attendance/viewAttendance";
	}

	@GetMapping("/list")
	public String listAttendance(Model model) {
		List<Attendance> attendanceList = attendanceService.getAllAttendance();
		model.addAttribute("attendanceList", attendanceList);
		return "attendance/attendanceList";
	}
	
	
	
	



//    @GetMapping("/mark")
//    public String showMarkAttendanceForm(Model model) {
//        // Add necessary attributes to the model if needed
//        model.addAttribute("students", studentService.getAllStudents());
//        return "attendance/markAttendance"; // This should match your HTML template name
//    }

	@GetMapping("/view/{date}")
	public String viewAttendance(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
			Model model) {
		// Assuming you have a service method to fetch attendance records for a
		// particular date
		// List<Attendance> attendanceList =
		// attendanceService.getAttendanceByDate(date);

		// For now, let's just add the date to the model
		model.addAttribute("date", date);
		// model.addAttribute("attendanceList", attendanceList);

		return "attendance-view";
	}

	@GetMapping("/edit/{id}")
	public String editAttendanceForm(@PathVariable Long id, Model model) {
		Attendance attendance = attendanceService.getAttendanceById(id);
		if (attendance == null) {
			return "redirect:/attendance/list"; // Handle record not found
		}
		model.addAttribute("attendance", attendance);
		return "attendance/updateAttendance"; // Path to updateAttendance.html
	}
	@GetMapping("/delete/{id}")
	public String deleteAttendanceForm(@PathVariable Long id, Model model) {
		 attendanceService.deleteAttendance(id);
		
		return "redirect:/attendance/list"; // Path to updateAttendance.html
	}

	@PostMapping("/update")
	public String updateAttendance(@ModelAttribute("attendance") Attendance attendance) {
		attendanceService.saveAttendance(attendance);
		return "redirect:/attendance/list"; // Redirect after updating
	}
}
