package iit.tn.example.cours.contrroller;

import iit.tn.example.cours.dto.StudentDto;
import iit.tn.example.cours.entity.Compte;
import iit.tn.example.cours.entity.Student;
import iit.tn.example.cours.service.StudentService;
import iit.tn.example.cours.service.StudentService2;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController2 {

    private final StudentService2 studentService;

    @GetMapping({"/index", "/"})
    public String index(Model model){
        model.addAttribute("students", studentService.findAll());
        return "students";
    }

    @PostMapping("/add-student")
    public String addStudent(@ModelAttribute Student student) {
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

    @ResponseBody
    @GetMapping("/get-student")
    public Student getStudent(@RequestParam Integer id) {
        return studentService.findById(id);
    }

    @ResponseBody
    @PutMapping("/update-student")
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }
}
