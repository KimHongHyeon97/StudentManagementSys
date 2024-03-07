package StudentInfo.studentInfo.controller;


import StudentInfo.studentInfo.student.Student;
import StudentInfo.studentInfo.student.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@Slf4j
@RequestMapping("/students")
@RequiredArgsConstructor
public class studentController {
    private final StudentRepository repository;
    @GetMapping("/studentSaveForm")
    public String saveStudentForm(Model model){
        log.info("GetMapping for saveStudentForm");
        model.addAttribute("student", new Student());
        return "/students/studentSaveForm";
    }
    @PostMapping("/studentSaveForm")
    public String saveStudent(@ModelAttribute Student student, RedirectAttributes redirectAttributes, Model model){
        log.info("PostMapping for saveStudent");
        repository.save(student);
        redirectAttributes.addAttribute("studentId", student.getId());
        redirectAttributes.addAttribute("status", true);
        return "redirect:/students/{studentId}";
    }

    @GetMapping("/studentList")
    public String studentList(Model model){
        log.info("studentList controller entered");
        model.addAttribute("students", repository.findAll());
        return "/students/studentList";
    }

    @GetMapping("/{studentId}")
    public String showStudentSpec(@PathVariable Long studentId, Model model){
        Student foundStudent = repository.findById(studentId).get();
        model.addAttribute("student", foundStudent);
        return "/students/studentSpec";
    }
}
