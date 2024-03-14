package StudentInfo.studentInfo.controller;


import StudentInfo.studentInfo.student.Student;
import StudentInfo.studentInfo.student.StudentRepository;
import StudentInfo.studentInfo.student.info.Assessment;
import StudentInfo.studentInfo.student.info.Grades;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        model.addAttribute("assessment", new Assessment());
        return "/students/studentSaveForm";
    }
    @PostMapping("/studentSaveForm")
    public String saveStudent(@ModelAttribute Student student, @ModelAttribute Assessment assessment, RedirectAttributes redirectAttributes, Model model){
        student.setAssessment(assessment);
        repository.save(student);
        redirectAttributes.addAttribute("studentId", student.getId());
        //redirectAttributes.addAttribute("status", true);
        return "redirect:/students/{studentId}";
    }

    @GetMapping("/{studentId}/studentEditForm")
    public String editStudentForm(@PathVariable Long studentId, Model model){
        Student foundStudent = repository.findById(studentId).get();
        model.addAttribute("student", foundStudent);
        model.addAttribute("assessment", foundStudent.getAssessment());
        return "/students/studentEditForm";

    }

    @PostMapping("/{studentId}/studentEditForm")
    public String editStudent(@ModelAttribute("student") Student student, @ModelAttribute Assessment assessment, @PathVariable Long studentId, RedirectAttributes redirectAttributes, Model model){
        repository.updateStudent(studentId, student, assessment);
        redirectAttributes.addAttribute("studentId", studentId);
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
        log.info("{}",foundStudent.getAssessment());
        model.addAttribute("assessment", foundStudent.getAssessment());
        log.info("showStudentSpec method entered");
        return "/students/studentSpec";
    }

    @ModelAttribute("grades")
    public List<Grades> grades(){
        List<Grades> grades = Arrays.asList(Grades.values());
        return grades;
    }
}
