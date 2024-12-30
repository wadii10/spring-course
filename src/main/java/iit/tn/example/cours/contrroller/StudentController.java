package iit.tn.example.cours.contrroller;

import iit.tn.example.cours.dto.StudentDto;
import iit.tn.example.cours.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalTime;

@Controller
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("students", studentService.getAll());
        return "students";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute StudentDto student) {
        studentService.addStudent(student);
        return "redirect:/students/index";
    }

    @PostMapping("/delete-student")
    public String deleteStudent(@RequestParam("id") int id) {
        studentService.deleteStudent(id);
        return "redirect:/students/index";
    }

    @ResponseBody
    @PostMapping("/delete-student-ajax")
    public void deleteStudentAjax(@RequestParam int id) {
        studentService.deleteStudent(id);
    }
}
